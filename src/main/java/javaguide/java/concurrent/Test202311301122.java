package javaguide.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Test202311301122 {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
    public int getCount() {
        return count.get();
    }
}