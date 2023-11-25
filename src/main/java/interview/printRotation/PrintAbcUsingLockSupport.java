package interview.printRotation;

import java.util.concurrent.locks.LockSupport;

public class PrintAbcUsingLockSupport {

    private static Thread threadA, threadB, threadC;

    public static void main(String[] args) {
        threadC = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                // 先阻塞等待被唤醒
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                // 唤醒下一个线程
                LockSupport.unpark(threadA);
            }
        }, "C");
        threadA = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                // 打印当前线程名称
                System.out.print(Thread.currentThread().getName());
                // 唤醒下一个线程
                LockSupport.unpark(threadB);
                // 当前线程阻塞
                LockSupport.park();
            }
        }, "A");
        threadB = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                // 先阻塞等待被唤醒
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                // 唤醒下一个线程
                LockSupport.unpark(threadC);
            }
        }, "B");
        //不会乱序打印
        threadC.start();
        threadB.start();
        threadA.start();
    }
}