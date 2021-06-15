package com.bingo.logic;

import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoRow;
import com.bingo.domain.entities.BingoUser;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.*;

@Component
public class BingoLogic {
    private static BingoLogic bingoLogic = new BingoLogic();

    public static BingoLogic init() {
        return bingoLogic;
    }

    private long level = 1L;
    private BingoMill bingoMill;
    private List<BingoCard> bingoCards;
    private BingoUser master;

    private boolean pause = true;
    private final Timer timer = new Timer();
    private final TimerTask task = new DrawNumberTask();

    /**
     * Create a bingo mill for the game, only if it doesn't exist yet.
     */
    public void createBingoMill() {
        if (bingoMill == null) {
            bingoMill = new BingoMill();
            timer.schedule(task, 0L);
        }
    }

    /**
     * A bingo user can become a game master, only if it doesn't exist yet.
     * It is not necessary to have a game master. The bingo can proceed without the master.
     *
     * @param bingoUser a bingo user who wants to become a game master
     * @return true if a bingo user becomes a master
     */
    public boolean becomeMaster(BingoUser bingoUser) {
        if (master == null) {
            master = bingoUser;
            return true;
        }
        return false;
    }

    /**
     * Checking if the participant has a bingo.
     *
     * @param bingoCard bingoCard with bingo.
     * @return true if it is a bingo.
     */
    public boolean checkBingo(BingoCard bingoCard) {
        long count = countBingoRows(bingoCard);
        return level >= count;
    }

    /**
     * Counting how many rows have a bingo.
     *
     * @param card Bingo card
     * @return a number of rows with bingo.
     */
    private long countBingoRows(BingoCard card) {
        List<String> drawNumbers = Arrays.asList(bingoMill.getDrawNumbers().split(","));
        return card.getBingoRows().stream()
                .mapToLong(row -> Arrays.stream(row.getNumbers()
                        .split(","))
                        .filter(drawNumbers::contains).count())
                .filter(result -> result == 5).count();
    }

    /**
     * Proceed or pause the bingo game.
     *
     * @return true if the bingo game is paused
     */
    public boolean togglePause() {
        pause = !pause;
        if (pause) {
            try {
                timer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            timer.notify();
        }
        return pause;
    }

    /**
     * Drawing a number from the bingo mill.
     *
     * @return drawn number
     */
    public long drawNumber() {
        var random = new SecureRandom();
        long drawNumber;
        while(true) {
            drawNumber = random.nextInt(75) + 1;
            if (!bingoMill.getDrawNumbers().contains("#" + drawNumber + ";")) {
                bingoMill.addDrawNumber(drawNumber);
                break;
            }
        }
        return drawNumber;
    }

    /**
     * Go to the next level.
     *
     * @return current level
     */
    public long nextLevel() {
        level++;
        if (level > 4) {
            timer.cancel();
        }
        return level;
    }

    /**
     * Join the bingo with bingo card to the bingo card list.
     *
     * @param bingoCard bingo card
     * @return true if the bingo card is added to the list
     */
    public boolean joinBingo(BingoCard bingoCard) {
        if (bingoCards == null) {
            bingoCards = new ArrayList<>();
        }
        if (bingoCards.contains(bingoCard)) {
            this.bingoCards.add(bingoCard);
            return true;
        }
        return false;
    }

    public BingoMill getBingoMill() {
        return bingoMill;
    }
}
