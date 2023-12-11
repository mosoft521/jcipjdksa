package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;

public class DelayedTaskTest {
    @Test
    public void delayedTaskTest() throws InterruptedException {
        // 创建延迟队列，并添加任务
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        //分别添加1s、2s、3s到期的任务
        delayQueue.add(new DelayedTask(2000, () -> System.out.println("Task 2")));
        delayQueue.add(new DelayedTask(1000, () -> System.out.println("Task 1")));
        delayQueue.add(new DelayedTask(3000, () -> System.out.println("Task 3")));

        // 取出任务并执行
        while (!delayQueue.isEmpty()) {
            //阻塞获取最先到期的任务
            DelayedTask task = delayQueue.take();
            if (task != null) {
                task.execute();
            }
        }
    }
}
/*
Task 1
Task 2
Task 3

Process finished with exit code 0
 */