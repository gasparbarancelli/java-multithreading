package com.gasparbarancelli.multithreading.theSynchronizedKeyword;

public class ExampleWithError2 {

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        new ExampleWithError2().run();
    }

    private void run() throws InterruptedException {
        var thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }

}

