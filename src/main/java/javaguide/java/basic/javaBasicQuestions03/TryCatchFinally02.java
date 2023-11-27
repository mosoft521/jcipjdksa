package javaguide.java.basic.javaBasicQuestions03;

public class TryCatchFinally02 {
    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}
/*
0
 */