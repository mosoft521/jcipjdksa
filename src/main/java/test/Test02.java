package test;

/**
 * https://blog.csdn.net/xyh269/article/details/52613507
 */
public class Test02 {
    public static void main(String[] args) {

        Service02 service02 = new Service02();

        Thread sleepThread = new Thread(new SleepThread02(service02));
        Thread waitThread = new Thread(new WaitThread02(service02));
        sleepThread.start();
        waitThread.start();
    }
}
/*
等待开始 。 当前时间：1701312212981
唤醒等待 。 结束时间：1701312215993
Process finished with exit code 0
有时候会打印如下：
唤醒等待 。 结束时间：1701312199021
等待开始 。 当前时间：1701312199021
线程未结束
 */