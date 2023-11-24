package com.gmail.mosoft521.jcipjdksa.ch01.project112;

public class MainLambda {
    public static void main(String[] args) {
        System.out.println("main enter!");

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t1 is executing");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }).start();
        System.out.println("main exit");
    }
}
