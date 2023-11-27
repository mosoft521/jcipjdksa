package javaguide.java.basic.javaBasicQuestions02;

public class StringTest6 {
    public static void main(String[] args) {
        final String str1 = "str";
        final String str2 = getStr();
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 在堆上创建的新的对象
        System.out.println(c == d);// false
    }

    public static String getStr() {
        return "ing";
    }
}