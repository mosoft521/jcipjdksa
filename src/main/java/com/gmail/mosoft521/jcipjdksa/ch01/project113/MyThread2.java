package com.gmail.mosoft521.jcipjdksa.ch01.project113;

import java.util.concurrent.TimeUnit;

public class MyThread2 extends Thread {

    private Object obj1 = new Object();
    private boolean stopped = false;

    public void run() {
        while (!stopped) {
            synchronized (obj1) { // 线程阻塞在这个地方
                int a = 1, b = 2;
                int c = a + b;
                System.out.println("thread is executing!");
            }
        }
    }

    public void stop2() {
        this.stopped = true;
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread2 t = new MyThread2();
        synchronized (t.obj1) {
            t.obj1.wait();
            t.start();
            t.interrupt();
            TimeUnit.SECONDS.sleep(3);
            t.stop2();
            t.join();
        }
    }
}
