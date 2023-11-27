package javaguide.java.basic.javaBasicQuestions01;

public class IntegerTest {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i + 1); // -2147483648
        System.out.println(i + 1 == Integer.MIN_VALUE); // true
    }
}
