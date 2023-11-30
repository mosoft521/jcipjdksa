package javaguide.java.concurrent;

public class SynchronizedDemo3 {
    public synchronized void method1() {
        System.out.println("方法1");
        method2();
    }

    public synchronized void method2() {
        System.out.println("方法2");
    }
}