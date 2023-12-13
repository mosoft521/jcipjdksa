package test.mt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 关于多线程：线程在Java中永不停止，解决方案之2
 */
public class StopThreadDemo4 {
    private static AtomicBoolean stopRequested = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(stopRequested.get());
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested.get()) {
                    i++;
                }
                System.out.println("done");
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested.compareAndSet(false, true);
    }
}
/*
false
done

进程已结束，退出代码为 0
 */