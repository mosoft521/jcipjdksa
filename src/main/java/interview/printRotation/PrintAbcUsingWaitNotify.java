package interview.printRotation;

public class PrintAbcUsingWaitNotify {

    private int state;
    private int times;
    private static final Object LOCK = new Object();

    public PrintAbcUsingWaitNotify(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintAbcUsingWaitNotify printAbcUsingWaitNotify = new PrintAbcUsingWaitNotify(3);
        //启动三个线程，无所谓顺序
        new Thread(() -> printAbcUsingWaitNotify.printLetter("A", 0), "A").start();
        new Thread(() -> printAbcUsingWaitNotify.printLetter("B", 1), "B").start();
        new Thread(() -> printAbcUsingWaitNotify.printLetter("C", 2), "C").start();
    }

    private void printLetter(String name, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (LOCK) {
                while (state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }
}