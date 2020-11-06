package com.gasparbarancelli.multithreading.startingThreads;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println("Main Thread Id: " + Thread.currentThread().getId());

        var runnable = new MyRunnable();

        new Thread(runnable).start();
        new Thread(runnable).start();;
        new Thread(runnable).start();;
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        var threadId = Thread.currentThread().getId();

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread Id: " + threadId + ", Value: " + i);
        }
    }
}
