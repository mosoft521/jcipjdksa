package javaguide.java.concurrent;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * https://juejin.cn/post/6844904151567040519
 * https://javaguide.cn/java/concurrent/threadlocal.html
 */
public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    private static final ThreadLocal<ThreadLocalTest> holder = new ThreadLocal<ThreadLocalTest>() {
        @Override
        protected ThreadLocalTest initialValue() {
            return new ThreadLocalTest();
        }
    };

    //lambda
//    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(()->new ThreadLocalTest());

//    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadLocalTest.add("一枝花算不算浪漫");
        ThreadLocalTest.add("一枝花算不算浪漫2");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}
/*
[一枝花算不算浪漫]
size: 0
 */