package com.gasparbarancelli.multithreading.theSynchronizedKeyword;

public class Demo1 {

    private int count = 0;

    public static void main(String[] args) {
        new Demo1().run();
    }

    private void run() {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
        }).start();

        System.out.println(count);
    }

}
