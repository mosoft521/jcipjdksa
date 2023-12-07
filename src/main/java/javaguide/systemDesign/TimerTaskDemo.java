package javaguide.systemDesign;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        timer.schedule(task, delay);
    }
}
/*
当前时间: Thu Dec 07 20:37:32 CST 2023n线程名称: main
当前时间: Thu Dec 07 20:37:33 CST 2023n线程名称: Timer
 */