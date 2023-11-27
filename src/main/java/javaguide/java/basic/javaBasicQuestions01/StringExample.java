package javaguide.java.basic.javaBasicQuestions01;

public class StringExample {
    // 字符型常量
    public static final Character LETTER_A = 'A';

    // 字符串常量
    public static final String GREETING_MESSAGE = "Hello";

    public static void main(String[] args) {
        System.out.println("字符型常量占用的字节数为：" + Character.BYTES);//2
        System.out.println("字符串常量占用的字节数为：" + GREETING_MESSAGE.getBytes().length);//5
    }
}