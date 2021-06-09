package com.bingo.logic;

import com.bingo.domain.builders.BingoCardBuilder;
import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BingoLogic {
    private long level = 1L;
    private BingoMill bingoMill;
    private List<BingoCard> bingoCards;
    private BingoUser master;
    private List<BingoUser> participants;

    private boolean pause = true;
    private Timer timer = new Timer();
    private TimerTask task = new DrawNumberTask();

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
     * Joining the bingo game.
     * The participant will enter the participant list and get a bingo card.
     *
     * @param participant Bingo user joining the bingo game.
     */
    public void join(BingoUser participant) {
        if (!participants.contains(participant)) {
            participants.add(participant);
        }
    }

    /**
     * Checking if the participant has a bingo.
     *
     * @param participant participant who called for a bingo.
     * @return true if it is a bingo.
     */
    public boolean checkBingo(BingoUser participant) {
        BingoCard card = findCard(participant);
        long count = countBingoRows(card);
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
     * Finding participant's bingo card.
     *
     * @param participant an owner
     * @return participant's bingo card
     */
    public BingoCard findCard(BingoUser participant) {
        return bingoCards.stream()
                .filter(card -> card.getUser().getId() == participant.getId())
                .findFirst()
                .orElse(null);
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
        Random random = new Random();
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
     * Go to the next level
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
     * Create a new bingoCard
     *
     * @param user user
     * @return bingoCard
     */
    public BingoCard createBingoCard(BingoUser user) {
        return new BingoCardBuilder(user);
    }
}
