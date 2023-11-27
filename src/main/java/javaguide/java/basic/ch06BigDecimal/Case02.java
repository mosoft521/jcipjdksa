package javaguide.java.basic.ch06BigDecimal;

import java.math.BigDecimal;

public class Case02 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x.compareTo(y));// 0
    }
}
