package com.gasparbarancelli.multithreading.theSynchronizedKeyword;

public class Demo4 {
    private int count = 0;

    private synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        new Demo4().run();
    }

    private void run() throws InterruptedException {
        var thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }

}
