package javaguide.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetTimeoutDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        String s = submit.get(3, TimeUnit.SECONDS);
        System.out.println(s);
        executorService.shutdown();
    }
}
/*
Exception in thread "main" java.util.concurrent.TimeoutException
 */