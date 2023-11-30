package javaguide.java.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * https://javaguide.cn/java/concurrent/completablefuture-intro.html
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1开始执行，当前时间：" + System.currentTimeMillis());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1执行完毕，当前时间：" + System.currentTimeMillis());
            return "task1";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2开始执行，当前时间：" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2执行完毕，当前时间：" + System.currentTimeMillis());
            return "task2";
        });

        task.acceptEitherAsync(task2, (res) -> {
            System.out.println("任务3开始执行，当前时间：" + System.currentTimeMillis());
            System.out.println("上一个任务的结果为：" + res);
        });

        // 增加一些延迟时间，确保异步任务有足够的时间完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
任务1开始执行，当前时间：1701324402106
任务2开始执行，当前时间：1701324402107
任务1执行完毕，当前时间：1701324402613
任务3开始执行，当前时间：1701324402613
上一个任务的结果为：task1
任务2执行完毕，当前时间：1701324403121
 */
