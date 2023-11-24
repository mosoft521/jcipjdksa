package com.zoterap.javabasic.current;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * https://www.cnblogs.com/zhumengke/articles/13555287.html
 * Thread.interrupt()的理解
 */
public class ThreadInterruptDemo {

    public static String getCurrentTime() {
        return LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS"));
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(
                        format("current i[%d], dateTime[%s]",
                                i, getCurrentTime()));

                try {
                    SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("EXCEPTION:" + e.getMessage());
                    Thread.currentThread().interrupt();
                }

            }
        });

        /**
         * 开启线程
         */
        t.start();

        /**
         * 主线程休眠5秒
         */
        try {
            SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 打断线程，尝试中断
         */
        t.interrupt();
    }
}