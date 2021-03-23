package nl.bingo.logic;

import java.util.TimerTask;

public class DrawNumberTask extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        try {
            //Wait for every 15 seconds.
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Draw a number");
    }
}
