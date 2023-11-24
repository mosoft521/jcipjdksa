package com.gmail.mosoft521.jcipjdksa.ch01.project112;

public class MainLambdaSetDaemon {
    public static void main(String[] args) {
        System.out.println("main enter!");

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t1 is executing");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("main exit");
    }
}
