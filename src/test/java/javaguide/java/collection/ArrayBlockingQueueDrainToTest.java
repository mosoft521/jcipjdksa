package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDrainToTest {
    @Test
    public void drainToTest() {
        // 创建一个大小为 5 的 ArrayBlockingQueue
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // 向队列中添加元素
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        // 创建一个 List，用于存储从队列中取出的元素
        List<Integer> list = new ArrayList<>();
        // 从队列中取出所有元素，并添加到 List 中
        queue.drainTo(list);
        // 输出 List 中的元素
        System.out.println(list);
    }
}
/*
[1, 2, 3, 4, 5]
 */