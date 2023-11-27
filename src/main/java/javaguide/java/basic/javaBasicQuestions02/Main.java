package javaguide.java.basic.javaBasicQuestions02;

/**
 * 面向过程
 */
public class Main {
    public static void main(String[] args) {
        // 定义圆的半径
        double radius = 3.0;

        // 计算圆的面积和周长
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        // 输出圆的面积和周长
        System.out.println("圆的面积为：" + area);
        System.out.println("圆的周长为：" + perimeter);
    }
}
/*
圆的面积为：28.274333882308138
圆的周长为：18.84955592153876
 */