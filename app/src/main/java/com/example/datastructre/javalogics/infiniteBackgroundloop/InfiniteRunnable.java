package com.example.datastructre.javalogics.infiniteBackgroundloop;

public class InfiniteRunnable implements Runnable{

    private volatile boolean isRunning = true;

    private BackgroundTaskInterface backgroundTaskInterface;

    public InfiniteRunnable(BackgroundTaskInterface backgroundTaskInterface) {
        this.backgroundTaskInterface = backgroundTaskInterface;
    }
    @Override
    public void run() {
        while (isRunning) {
            backgroundTaskInterface.speed(); // Call your method via interface
            System.out.println("run  thread = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopTask() {
        isRunning = false;
    }
}
