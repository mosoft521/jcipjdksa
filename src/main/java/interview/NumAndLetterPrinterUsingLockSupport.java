package interview;

import java.util.concurrent.locks.LockSupport;

public class NumAndLetterPrinterUsingLockSupport {

    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                LockSupport.unpark(numThread);
                LockSupport.park();
                System.out.print((char) ('A' + i));
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                LockSupport.park();
                System.out.print(i);
                LockSupport.unpark(letterThread);
            }
        }, "numThread");
        letterThread.start();
        numThread.start();
    }
}