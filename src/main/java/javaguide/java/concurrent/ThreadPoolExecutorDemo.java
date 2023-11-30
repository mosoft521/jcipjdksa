package javaguide.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

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
pool-1-thread-1 Start. Time = Wed Nov 29 07:54:28 CST 2023
pool-1-thread-2 Start. Time = Wed Nov 29 07:54:28 CST 2023
pool-1-thread-3 Start. Time = Wed Nov 29 07:54:28 CST 2023
pool-1-thread-4 Start. Time = Wed Nov 29 07:54:28 CST 2023
pool-1-thread-5 Start. Time = Wed Nov 29 07:54:28 CST 2023
pool-1-thread-1 End. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-1 Start. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-2 End. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-2 Start. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-5 End. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-4 End. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-5 Start. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-4 Start. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-3 End. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-3 Start. Time = Wed Nov 29 07:54:33 CST 2023
pool-1-thread-1 End. Time = Wed Nov 29 07:54:38 CST 2023
pool-1-thread-3 End. Time = Wed Nov 29 07:54:38 CST 2023
pool-1-thread-4 End. Time = Wed Nov 29 07:54:38 CST 2023
pool-1-thread-5 End. Time = Wed Nov 29 07:54:38 CST 2023
pool-1-thread-2 End. Time = Wed Nov 29 07:54:38 CST 2023
Finished all threads

Process finished with exit code 0
// 任务全部执行完了才会跳出来，因为executor.isTerminated()判断为true了才会跳出while循环，
// 当且仅当调用 shutdown() 方法后，并且所有提交的任务完成后返回为 true
 */