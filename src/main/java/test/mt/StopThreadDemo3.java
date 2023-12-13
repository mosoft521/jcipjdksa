package test.mt;

import java.util.concurrent.TimeUnit;

/**
 * 关于多线程：线程在Java中永不停止，解决方案之1
 */
public class StopThreadDemo3 {
    private static volatile boolean stopRequested;

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
done

进程已结束，退出代码为 0
 */