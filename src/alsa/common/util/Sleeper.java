package alsa.common.util;

import java.util.Random;

public class Sleeper {
    private final String name;
    private final Random random = new Random();

    public Sleeper(String name){
        this.name = name;
    }

    public void randomSleep() {
        long timeInMs = Math.abs(Math.round(random.nextGaussian() * 500 + 1000));

        System.out.println("["+name+"]: Sleeping for " + timeInMs + " ms!");

        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
