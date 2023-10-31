package com.example.datastructre.javalogics.infiniteBackgroundloop;

public class CheckNetworkSpeed{

    public static void main(String[] args) {
        DoTask doTask = new DoTask();
        doTask.dotask();
    }

    static class DoTask implements BackgroundTaskInterface{
        private InfiniteRunnable infiniteRunnable;
        private int i =0;
        void dotask() {
            infiniteRunnable = new InfiniteRunnable(this);
            Thread thread = new Thread(infiniteRunnable);
            thread.start();
        }

        @Override
        public void speed() {
            System.out.println("speed " + i + " thread = " + Thread.currentThread().getName());
            i += 1;
            if (i > 10) {
                infiniteRunnable.stopTask();
            }
        }
    }
}
