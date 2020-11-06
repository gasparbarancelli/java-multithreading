package com.gasparbarancelli.multithreading.multipleLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExampleWithError2 {

    private final static Random RANDOM = new Random();

    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    private synchronized void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(RANDOM.nextInt(100));
    }

    private synchronized void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(RANDOM.nextInt(100));
    }

    private void process() {
        for (int i = 0; i < 1_000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() throws InterruptedException {
        System.out.println("Starting...");

        long start = System.currentTimeMillis();

        var thread1 = new Thread(this::process);
        var thread2 = new Thread(this::process);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + ", List2: " + list2.size());
    }

    public static void main(String[] args) throws InterruptedException {
        new ExampleWithError2().main();
    }

}
