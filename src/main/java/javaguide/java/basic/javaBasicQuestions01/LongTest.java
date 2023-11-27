package javaguide.java.basic.javaBasicQuestions01;

public class LongTest {
    public static void main(String[] args) {
        long l = Long.MAX_VALUE;
        System.out.println(l + 1); // -9223372036854775808
        System.out.println(l + 1 == Long.MIN_VALUE); // true
    }
}
