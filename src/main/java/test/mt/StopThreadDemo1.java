package test.mt;

import java.util.concurrent.TimeUnit;

/**
 * Thread never stops in Java
 */
public class StopThreadDemo1 {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(stopRequested);
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                }
                System.out.println("done");
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
/*
false
该程序永远不会停止。 它永远不会打印done。
 */