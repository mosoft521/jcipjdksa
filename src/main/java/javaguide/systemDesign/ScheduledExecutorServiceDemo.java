package javaguide.systemDesign;

import lombok.SneakyThrows;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        TimerTask repeatedTask = new TimerTask() {
            @SneakyThrows
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" + "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" + "线程名称: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        long delay = 1000L;
        long period = 1000L;
        executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
        Thread.sleep(delay + period * 5);
        executor.shutdown();
    }
}
/*
当前时间: Thu Dec 07 20:41:59 CST 2023n线程名称: main
当前时间: Thu Dec 07 20:42:00 CST 2023n线程名称: pool-1-thread-1
当前时间: Thu Dec 07 20:42:01 CST 2023n线程名称: pool-1-thread-1
当前时间: Thu Dec 07 20:42:02 CST 2023n线程名称: pool-1-thread-2
当前时间: Thu Dec 07 20:42:03 CST 2023n线程名称: pool-1-thread-1
当前时间: Thu Dec 07 20:42:04 CST 2023n线程名称: pool-1-thread-3
当前时间: Thu Dec 07 20:42:05 CST 2023n线程名称: pool-1-thread-2

Process finished with exit code 0
 */