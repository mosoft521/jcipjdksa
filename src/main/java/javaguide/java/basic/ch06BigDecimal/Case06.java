package javaguide.java.basic.ch06BigDecimal;

import java.math.BigDecimal;

public class Case06 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.equals(b));//false
        System.out.println(a.compareTo(b));//0
    }
}
