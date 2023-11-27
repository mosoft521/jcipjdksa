package javaguide.java.basic.javaBasicQuestions02;

public class Equals {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = "hello";
        // 使用 == 比较字符串的引用相等
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        // 使用 equals 方法比较字符串的相等
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));


    }
}
/*
false
true
true
true
 */