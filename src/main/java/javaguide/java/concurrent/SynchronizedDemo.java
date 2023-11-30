package javaguide.java.concurrent;

/**
 * javap -c -s -v -l SynchronizedDemo.class
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}