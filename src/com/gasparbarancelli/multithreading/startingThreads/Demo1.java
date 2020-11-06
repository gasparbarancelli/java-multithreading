package com.gasparbarancelli.multithreading.startingThreads;

public class Demo1 {

    public static void main(String[] args) {
        System.out.println("Main Thread Id: " + Thread.currentThread().getId());

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        var threadId = Thread.currentThread().getId();

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread Id: " + threadId + ", Value: " + i);
        }
    }

}
