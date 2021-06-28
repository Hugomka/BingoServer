package com.bingo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class DrawNumberTask extends TimerTask {
    private final Logger logger = LoggerFactory.getLogger(DrawNumberTask.class);
    private long count = 0L;

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        count++;
        logger.info(String.format("It is time for drawing a number! Count: %d times.", count));
    }
}
