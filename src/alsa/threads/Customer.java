package alsa.threads;

import alsa.services.EshopService;
import alsa.util.Sleeper;

public abstract class Customer {

    protected final String name;
    protected final EshopService eshopService;
    private boolean shouldRun = true;
    private Thread thread;
    private int counter = 0;
    private int successCounter = 0;

    public Customer(String name, EshopService eshopService) {
        this.name = name;
        this.eshopService = eshopService;
    }

    public void start() {
        thread = new Thread(() -> {
            Sleeper sleeper = new Sleeper(name);
            while (shouldRun) {
                if(goToEshop())
                    successCounter++;
                counter++;
                sleeper.randomSleep();
            }
        });
        thread.start();
    }

    public void join() {
        if(thread == null)
            throw new RuntimeException();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean goToEshop();

    public void stop() {
        shouldRun = false;
        if(thread == null)
            return;
        thread.interrupt();
    }

    public void printStats() {
        System.out.println("["+name+"]: Went to shop " + counter + " times, " + successCounter + " times successfully");
    }
}
