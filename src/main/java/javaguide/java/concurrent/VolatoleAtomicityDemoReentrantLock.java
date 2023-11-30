package javaguide.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatoleAtomicityDemoReentrantLock {
    public volatile static int inc = 0;

    Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatoleAtomicityDemoReentrantLock volatoleAtomicityDemoErr = new VolatoleAtomicityDemoReentrantLock();
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
