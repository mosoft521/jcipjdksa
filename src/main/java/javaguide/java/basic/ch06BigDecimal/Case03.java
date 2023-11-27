package javaguide.java.basic.ch06BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Case03 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        try {
            System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11
    }
}
