package javaguide.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrintThreadPoolStatusDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static ThreadFactory createThreadFactory(String prefix, boolean daemon) {
        return new NamedInternalThreadFactory(prefix, daemon);
    }

    /**
     * 打印线程池的状态
     *
     * @param threadPool 线程池对象
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                createThreadFactory("print-images/thread-pool-status", false));
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("=========================");
            System.out.printf("ThreadPool Size: [{%d}]", threadPool.getPoolSize());
            System.out.printf("Active Threads: {%d}", threadPool.getActiveCount());
            System.out.printf("Number of Tasks : {%d}", threadPool.getCompletedTaskCount());
            System.out.printf("Number of Tasks in Queue: {%d}", threadPool.getQueue().size());
            System.out.println("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        printThreadPoolStatus(executor);
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
/*
=========================
ThreadPool Size: [{5}]pool-1-thread-1 Start. Time = Wed Nov 29 10:01:12 CST 2023
pool-1-thread-4 Start. Time = Wed Nov 29 10:01:12 CST 2023
pool-1-thread-3 Start. Time = Wed Nov 29 10:01:12 CST 2023
pool-1-thread-2 Start. Time = Wed Nov 29 10:01:12 CST 2023
pool-1-thread-5 Start. Time = Wed Nov 29 10:01:12 CST 2023
Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {0}Number of Tasks in Queue: {5}=========================
pool-1-thread-1 End. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-1 Start. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-4 End. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-4 Start. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-3 End. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-3 Start. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-2 End. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-2 Start. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-5 End. Time = Wed Nov 29 10:01:17 CST 2023
pool-1-thread-5 Start. Time = Wed Nov 29 10:01:17 CST 2023
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {5}Number of Tasks in Queue: {0}=========================
=========================
ThreadPool Size: [{5}]Active Threads: {5}Number of Tasks : {5}Number of Tasks in Queue: {0}=========================
=========================
继续输出监控
 */