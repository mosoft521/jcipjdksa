package interview;

import java.util.concurrent.locks.LockSupport;

public class NumAndLetterPrinterUsingLockSupport {

    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(numThread);
                LockSupport.park();
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(letterThread);
            }
        }, "numThread");
        //会乱序，但还是交替打印
        numThread.start();
        letterThread.start();
    }
}