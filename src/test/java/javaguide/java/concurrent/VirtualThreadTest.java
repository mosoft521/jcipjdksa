package javaguide.java.concurrent;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 虚拟线程
 */
public class VirtualThreadTest {
    static class CustomThread implements Runnable {
        @Override
        public void run() {
            System.out.println("CustomThread run");//CustomThread run
        }
    }

    /**
     * 1.使用 Thread.startVirtualThread() 创建
     */
    @Test
    public void startVirtualThreadTest() {
        CustomThread customThread = new CustomThread();
        Thread.startVirtualThread(customThread);
    }

    /**
     * 2.使用 Thread.ofVirtual() 创建
     */
    @Test
    public void ofVirtualTest() {
        CustomThread customThread = new CustomThread();
        // 创建不启动
        Thread unStarted = Thread.ofVirtual().unstarted(customThread);
        unStarted.start();
        // 创建直接启动
        Thread.ofVirtual().start(customThread);
    }

    /**
     * 3.使用 ThreadFactory 创建
     */
    @Test
    public void ofVirtualFactoryTest() {
        CustomThread customThread = new CustomThread();
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread thread = factory.newThread(customThread);
        thread.start();
    }

    /**
     * 4.使用 Executors.newVirtualThreadPerTaskExecutor()创建
     */
    @Test
    public void newVirtualThreadPerTaskExecutorTest() {
        CustomThread customThread = new CustomThread();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(customThread);
    }

    static List<Integer> list = new ArrayList<>();

    // 更新创建的平台最大线程数
    private static void updateMaxThreadNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            Integer integer = list.get(0);
            if (num > integer) {
                list.add(0, num);
            }
        }
    }

    /**
     * @param taskNum   请求任务数
     * @param nThreads  线程数
     * @param isVirtual 是否虚线线程
     * @param costMs    模拟业务耗时毫秒数
     */
    private static void t(final int taskNum, final int nThreads, final boolean isVirtual, final int costMs) {
        // 开启线程 统计平台线程数
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfo = threadBean.dumpAllThreads(false, false);
            updateMaxThreadNum(threadInfo.length);
        }, 10, 10, TimeUnit.MILLISECONDS);

        long start = System.currentTimeMillis();
        // virtual ? 虚拟线程 : 平台线程
        ExecutorService executor = isVirtual ? Executors.newVirtualThreadPerTaskExecutor() : Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < taskNum; i++) {
            executor.submit(() -> {
                try {
                    // 线程睡眠 0.5 s，模拟业务处理
                    TimeUnit.MILLISECONDS.sleep(costMs);
                } catch (InterruptedException ignored) {
                }
            });
        }
        executor.close();
        System.out.println("Use " + (isVirtual ? "Virtual" : "Platform") + " Thread");
        if (!isVirtual) {
            System.out.println("nThreads: " + nThreads);
        }
        System.out.println("max：" + list.get(0) + " platform thread/os thread");
        System.out.printf("totalMillis：%dms\n", System.currentTimeMillis() - start);
    }

    @Test
    public void test101() {
        t(10000, 0, true, 500);
    }

    @Test
    public void test102() {
        t(10000, 200, false, 500);
    }

    @Test
    public void test103() {
        t(10000, 500, false, 500);
    }

    @Test
    public void test104() {
        t(10000, 1000, false, 500);
    }

    @Test
    public void test105() {
        t(10000, 2000, false, 500);
    }

    @Test
    public void test201() {
        t(10000, 0, true, 1000);
    }

    @Test
    public void test202() {
        t(10000, 200, false, 1000);
    }

    @Test
    public void test203() {
        t(10000, 500, false, 1000);
    }

    @Test
    public void test204() {
        t(10000, 1000, false, 1000);
    }

    @Test
    public void test205() {
        t(10000, 2000, false, 1000);
    }
}
/*
请求数 10000 单请求耗时 0.5s：
Use Virtual Thread
max：14 platform thread/os thread
totalMillis：906ms
Use Platform Thread
nThreads: 200
max：215 platform thread/os thread
totalMillis：25572ms
Use Platform Thread
nThreads: 500
max：516 platform thread/os thread
totalMillis：10625ms
Use Platform Thread
nThreads: 1000
max：1016 platform thread/os thread
totalMillis：6435ms
Use Platform Thread
nThreads: 2000
max：2017 platform thread/os thread
totalMillis：5796ms
请求数 10000 单请求耗时 1s：
Use Virtual Thread
max：14 platform thread/os thread
totalMillis：1429ms
Use Platform Thread
nThreads: 200
max：215 platform thread/os thread
totalMillis：50654ms
Use Platform Thread
nThreads: 500
max：515 platform thread/os thread
totalMillis：20703ms
Use Platform Thread
nThreads: 1000
max：1015 platform thread/os thread
totalMillis：11416ms
Use Platform Thread
nThreads: 2000
max：2016 platform thread/os thread
totalMillis：8080ms
 */