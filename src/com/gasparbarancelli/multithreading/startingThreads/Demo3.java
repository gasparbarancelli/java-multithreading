package com.gasparbarancelli.multithreading.startingThreads;

public class Demo3 {

    public static void main(String[] args) {
        var thread1 = new Thread(new MyRunnable());
        var thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        System.out.println("Main Thread ID: " + Thread.currentThread().getId());
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            System.out.println("Running in parallel");
        }
    }

}
