package interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://mp.weixin.qq.com/s/bm9m7kcuSmU-8acgW5dL4Q
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串。
 * 思路：使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，他们与 3 取模结果仍为本身，则执行打印逻辑。
 */
public class PrintAbcUsingLock {

    private int times; // 控制打印次数
    private int state;   // 当前状态值：保证三个线程之间交替打印
    private Lock lock = new ReentrantLock();

    public PrintAbcUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintAbcUsingLock printAbcUsingLock = new PrintAbcUsingLock(3);
        //启动三个线程，无所谓顺序
        new Thread(() -> printAbcUsingLock.printLetter("A", 0), "A").start();
        new Thread(() -> printAbcUsingLock.printLetter("B", 1), "B").start();
        new Thread(() -> printAbcUsingLock.printLetter("C", 2), "C").start();
    }
}