package javaguide.java.newFeatures.java11;

import java.util.stream.Collectors;

public class StringDemo {
    public static void main(String[] args) {
        //判断字符串是否为空
        " ".isBlank();//true
        //去除字符串首尾空格
        " Java ".strip();// "Java"
        //去除字符串首部空格
        " Java ".stripLeading();   // "Java "
        //去除字符串尾部空格
        " Java ".stripTrailing();  // " Java"
        //重复字符串多少次
        "Java".repeat(3);             // "JavaJavaJava"
        //返回由行终止符分隔的字符串集合。
        "A\nB\nC".lines().count();    // 3
        "A\nB\nC".lines().collect(Collectors.toList());
    }
}