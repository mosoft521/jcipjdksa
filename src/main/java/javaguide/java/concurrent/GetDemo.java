package javaguide.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GetDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
    }
}
/*
abc

Process finished with exit code 0
 */