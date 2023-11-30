package javaguide.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatoleAtomicityDemoSynchronized {
    public volatile static int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatoleAtomicityDemoSynchronized volatoleAtomicityDemoErr = new VolatoleAtomicityDemoSynchronized();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatoleAtomicityDemoErr.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
/*
2500
Process finished with exit code 0
 */
