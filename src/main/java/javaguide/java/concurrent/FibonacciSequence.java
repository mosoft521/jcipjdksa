package javaguide.java.concurrent;

public class FibonacciSequence {

    public static int fs(int t) {
        switch (t) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fs(t - 1) + fs(t - 2);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            int fib = fs(i);
            System.out.println(i + "\t\t" + fib);
            if (fib > 0x61c88647) {
                return;
            }
        }
    }
}
