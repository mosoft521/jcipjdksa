package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbcUsingLockCondition {

    private int times;
    private int state;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public PrintAbcUsingLockCondition(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintAbcUsingLockCondition printAbcUsingLockCondition = new PrintAbcUsingLockCondition(3);
        new Thread(() -> printAbcUsingLockCondition.printLetter("C", 2, c3, c1), "C").start();
        new Thread(() -> printAbcUsingLockCondition.printLetter("A", 0, c1, c2), "A").start();
        new Thread(() -> printAbcUsingLockCondition.printLetter("B", 1, c2, c3), "B").start();
    }

    private void printLetter(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    current.await();
                }
                state++;
                i++;
                System.out.print(name);
                next.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}