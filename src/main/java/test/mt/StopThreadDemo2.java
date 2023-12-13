package test.mt;

import java.util.concurrent.TimeUnit;

/**
 * https://www.codenong.com/35809700/
 */
public class StopThreadDemo2 {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(stopRequested);
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                    System.out.println(i); // 多了这句
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
1
2
3
...
116192
116193
done

进程已结束，退出代码为 0。
 */