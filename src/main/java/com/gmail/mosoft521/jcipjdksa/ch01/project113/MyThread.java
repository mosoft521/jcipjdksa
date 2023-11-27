package com.gmail.mosoft521.jcipjdksa.ch01.project113;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
    private boolean stopped = false;

    public void run() {
        while (!stopped) {
            int a = 1, b = 2;
            int c = a + b;
            System.out.println("thread is executing!");
        }
    }

    public void stop2() {
        this.stopped = true;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.interrupt();
        TimeUnit.SECONDS.sleep(3);
        t.stop2();
        t.join();
    }
}
