package javaguide.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://javaguide.cn/java/concurrent/aqs.html
 */
public class CountDownLatchExample {
    // 请求的数量
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        // 只是测试使用，实际场景请手动赋值线程池参数
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 表示一个请求已经被完成
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadnum);
        Thread.sleep(1000);
    }
}
/*
threadNum:3
threadNum:0
threadNum:1
threadNum:2
threadNum:7
threadNum:5
threadNum:4
threadNum:6
threadNum:8
threadNum:9
finish
 */