package test;

/**
 * https://blog.csdn.net/xyh269/article/details/52613507
 */
public class Test01 {
    public static void main(String[] args) {

        Service01 service01 = new Service01();

        Thread sleepThread = new Thread(new SleepThread01(service01));
        Thread waitThread = new Thread(new WaitThread01(service01));
        sleepThread.start();
        waitThread.start();
    }
}
/*
Sleep 。当前时间：1701312018361
Wait 。结束时间：1701312021374

Process finished with exit code 0
 */