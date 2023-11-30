package javaguide.java.concurrent;

/**
 * javap -c -s -v -l SynchronizedDemo2.class
 */
public class SynchronizedDemo2 {
    public synchronized void method() {
        System.out.println("synchronized 方法");
    }
}
