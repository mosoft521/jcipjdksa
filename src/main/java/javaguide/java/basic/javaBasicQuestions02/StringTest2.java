package javaguide.java.basic.javaBasicQuestions02;

public class StringTest2 {
    public static void main(String[] args) {
        // 在堆中创建字符串对象”ab“
        // 将字符串对象”ab“的引用保存在字符串常量池中
        String aa = "ab";
        // 直接返回字符串常量池中字符串对象”ab“的引用
        String bb = "ab";
        System.out.println(aa == bb);// true
    }
}
