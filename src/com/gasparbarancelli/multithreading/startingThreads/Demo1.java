package com.gasparbarancelli.multithreading.startingThreads;

public class Demo1 {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            System.out.println("Running in parallel");
        });
        thread.start();
        System.out.println("Main Thread ID: " + Thread.currentThread().getId());
    }

}
