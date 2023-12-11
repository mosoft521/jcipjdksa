package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ArrayBlockingQueueProducerConsumerTest {
    @Test
    public void arrayBlockingQueueTest() throws InterruptedException {
        // 创建一个大小为 5 的 ArrayBlockingQueue
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // 创建生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    // 向队列中添加元素，如果队列已满则阻塞等待
                    queue.put(i);
                    System.out.println("生产者添加元素：" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 创建消费者线程
        Thread consumer = new Thread(() -> {
            try {
                int count = 0;
                while (true) {
                    // 从队列中取出元素，如果队列为空则阻塞等待
                    int element = queue.take();
                    System.out.println("消费者取出元素：" + element);
                    ++count;
                    if (count == 10) {
                        break;
                    }
                }
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 启动线程
        producer.start();
        consumer.start();
        // 等待线程结束
        producer.join();
        consumer.join();
        countDownLatch.await();
        producer.interrupt();
        consumer.interrupt();
    }
}
/*
生产者添加元素：1
生产者添加元素：2
生产者添加元素：3
生产者添加元素：4
生产者添加元素：5
生产者添加元素：6
消费者取出元素：1
消费者取出元素：2
消费者取出元素：3
消费者取出元素：4
消费者取出元素：5
消费者取出元素：6
生产者添加元素：7
消费者取出元素：7
消费者取出元素：8
生产者添加元素：8
生产者添加元素：9
消费者取出元素：9
消费者取出元素：10
生产者添加元素：10
#第二次运行
生产者添加元素：1
消费者取出元素：1
生产者添加元素：2
生产者添加元素：3
生产者添加元素：4
生产者添加元素：5
生产者添加元素：6
消费者取出元素：2
消费者取出元素：3
消费者取出元素：4
消费者取出元素：5
消费者取出元素：6
生产者添加元素：7
生产者添加元素：8
生产者添加元素：9
生产者添加元素：10
消费者取出元素：7
消费者取出元素：8
消费者取出元素：9
消费者取出元素：10

Process finished with exit code 0
 */