package com.gasparbarancelli.multithreading.basicThreadSynchronization;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Main Thread Id: " + Thread.currentThread().getId());

        var thread = new MyThread();
        thread.start();

        System.out.println("press any key to stop thread...");
        var scanner = new Scanner(System.in);
        scanner.nextLine();

        thread.disconnect();
    }
}

class MyThread extends Thread {

    private boolean running = true;

    @Override
    public void run() {
        var threadId = Thread.currentThread().getId();

        while (running) {
            System.out.println("Thread Id: " + threadId);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        running = false;
    }

}
