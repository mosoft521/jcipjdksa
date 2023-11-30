package javaguide.java.concurrent;

public class Test202311301121 {
    private volatile int count = 0;

    //若要线程安全执行执行count++，需要加锁
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}