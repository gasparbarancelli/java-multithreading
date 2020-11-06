package com.gasparbarancelli.multithreading.startingThreads;

public class Demo2 {

    public static void main(String[] args) {
        var thread = new MyThread();
        thread.start();
        System.out.println("Main Thread ID: " + Thread.currentThread().getId());
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            System.out.println("Running in parallel");
        }
    }

}
