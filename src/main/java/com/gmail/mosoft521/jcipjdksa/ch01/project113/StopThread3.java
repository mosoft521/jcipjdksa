package com.gmail.mosoft521.jcipjdksa.ch01.project113;

import java.util.concurrent.TimeUnit;

public class StopThread3 {
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println(stopRequested);
        Thread backgroundThread = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                int i = 0;
                while (!stopRequested) {
                    i++;
                }

                System.out.println("done");
            }

        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
    }

}
