package com.gasparbarancelli.multithreading.startingThreads;

public class Demo3 {

    public static void main(String[] args) {
        System.out.println("Main Thread ID: " + Thread.currentThread().getId());

        new Thread(new Runnable() {
            @Override
            public void run() {
                loop();
            }
        }).start();

        // lambda
        new Thread(() -> loop()).start();

        // method reference
        new Thread(Demo3::loop).start();
    }

    private static void loop() {
        var threadId = Thread.currentThread().getId();

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread Id: " + threadId + ", Value: " + i);
        }
    }

}
