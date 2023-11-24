package interview;

public class OddEvenPrinterUsingWaitNotify {

    private Object monitor = new Object();
    private final int times;
    private volatile int count;

    OddEvenPrinterUsingWaitNotify(int initCount, int times) {
        this.count = initCount;
        this.times = times;
    }

    public static void main(String[] args) {

        OddEvenPrinterUsingWaitNotify oddEvenPrinterUsingWaitNotify = new OddEvenPrinterUsingWaitNotify(0, 10);
        //会乱打，呵呵。
        new Thread(oddEvenPrinterUsingWaitNotify::print, "odd").start();//奇数
        new Thread(oddEvenPrinterUsingWaitNotify::print, "even").start();//偶数
    }

    private void print() {
        synchronized (monitor) {
            while (count < times) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
            monitor.notifyAll();
        }
    }
}
/*
线程[odd]打印数字:1
线程[even]打印数字:2
线程[odd]打印数字:3
线程[even]打印数字:4
线程[odd]打印数字:5
线程[even]打印数字:6
线程[odd]打印数字:7
线程[even]打印数字:8
线程[odd]打印数字:9
线程[even]打印数字:10
 */