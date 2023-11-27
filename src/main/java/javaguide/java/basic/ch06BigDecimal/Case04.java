package javaguide.java.basic.ch06BigDecimal;

import java.math.BigDecimal;

public class Case04 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.compareTo(b));// 1
    }
}
