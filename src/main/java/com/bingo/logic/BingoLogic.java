package com.bingo.logic;

import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoRow;
import com.bingo.domain.entities.BingoUser;
import com.bingo.repos.BingoRowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(BingoLogic.class);

    /**
     * Create a bingo mill for the game, only if the bingo mill doesn't exist yet.
     */
    public void openBingoMill(BingoMill bingoMill) {
        if (level > 5) {
            bingoLogic = new BingoLogic();
            logger.warn(String.format("The bingo game was already over. The bingo mill id %s is invalid.", bingoMill.getId()));
        }
        if (this.bingoMill == null) {
            this.bingoMill = bingoMill;
            timer.schedule(task, 0L,15000L);
            logger.info("The bingo game is starting now.");
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
            logger.info(bingoUser.getUsername() + " is a bingo master now.");
            return true;
        }
        logger.warn("There is already a bingo master and that is " + master.getUsername() + ".");
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
        if (level < count) {
            logger.warn(String.format("Alas, that is no Bingo! %s made a mistake with the bingo call at the level %d.",
                    bingoCard.getUser().getUsername(), level));
            return false;
        }
        logger.info(String.format("That is Bingo! The winner of the level %d  is %s.",
                level, bingoCard.getUser().getUsername()));
        return true;
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
    public boolean pause(boolean pause) {
        if (pause) {
            try {
                timer.wait();
                logger.info("The bingo game is paused.");
            } catch (InterruptedException e) {
                e.printStackTrace();
                pause = false;
            }
        } else {
            timer.notifyAll();
            logger.info("The bingo game is running.");
        }
        this.pause = pause;
        return pause;
    }

    /**
     * Drawing a number from the bingo mill.
     *
     * @return drawn number
     */
    public long drawNumber(UUID bingoMillId) {
        try {
            checkId(bingoMillId);
            var random = new SecureRandom();
            long drawNumber;
            while (true) {
                drawNumber = random.nextInt(75) + 1;
                if (!bingoMill.getDrawNumbers().contains("#" + drawNumber + ";")) {
                    bingoMill.addDrawNumber(drawNumber);
                    break;
                }
            }
            logger.info(String.format("Just drew a number %d for bingo mill id: %s.", drawNumber, bingoMillId));
            return drawNumber;
        }
        catch (IllegalAccessException ex) {
            return 0;
        }
    }

    /**
     * Check if the bingoMillId is still same.
     * @param bingoMillId bingo mill id
     */
    private void checkId(UUID bingoMillId) throws IllegalAccessException {
        if(!bingoMill.getId().equals(bingoMillId)) {
            logger.warn(String.format("Bingo mill id is mismatched.\r\nExpected: %s\r\nActual: %s",
                    bingoMillId, this.bingoMill.getId()));
            throw new IllegalAccessException(String.format("Bingo mill ID %s is expired.", bingoMillId));
        }
    }

    /**
     * Go to the next level.
     *
     * @return current level
     */
    public long nextLevel() {
        level++;
        if (level > 5) {
            timer.cancel();
            logger.info("The bingo game is over.");
        }
        else {
            logger.info(String.format("The bingo game level is %d.", level));
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
        if (!bingoCards.contains(bingoCard)) {
            this.bingoCards.add(bingoCard);
            logger.info(bingoCard.getUser().getUsername() + " just joined the bingo game.");
            return true;
        }
        logger.warn(bingoCard.getUser().getUsername() + " already joined the bingo game.");
        return false;
    }

    /**
     * Get bingo mill
     *
     * @return bingo mill
     */
    public BingoMill getBingoMill() {
        logger.info("Returning the bingo mill to the client.");
        return bingoMill;
    }

    /**
     * Generate rows for bingo card. Also checking and adding rows in the database
     *
     * @param bingoCard bingo card
     * @param bingoRowRepository bingo row repository
     */
    public void generateRows(BingoCard bingoCard, BingoRowRepository bingoRowRepository) {
        List<BingoRow> bingoRows = new ArrayList<>();
        List<Long> addedNumbers = new ArrayList<>();
        while (bingoRows.size() < 5) {
            BingoRow bingoRow;
            while(true) {
                long b = randomCorrectNumber(addedNumbers, 1L);
                long i = randomCorrectNumber(addedNumbers,16L);
                long n = randomCorrectNumber(addedNumbers, 31L);
                long g = randomCorrectNumber(addedNumbers, 46L);
                long o = randomCorrectNumber(addedNumbers, 61L);
                String generatedNumbers = String.format("%d,%d,%d,%d,%d", b, i, n, g, o);
                if (!bingoRowRepository.existsByNumbers(generatedNumbers)) {
                    bingoRow = new BingoRow(generatedNumbers);
                    break;
                }
            }
            bingoRows.add(bingoRow);
        }
        bingoCard.setBingoRows(bingoRows);
    }

    private long randomCorrectNumber(List<Long> addedNumbers, long lowestNumber) {
        var random = new SecureRandom();
        long randomNum;
        while (true) {
            randomNum = random.nextInt(15) + lowestNumber;
            if (!addedNumbers.contains(randomNum)) {
                addedNumbers.add(randomNum);
                break;
            }
        }
        return randomNum;
    }
}
