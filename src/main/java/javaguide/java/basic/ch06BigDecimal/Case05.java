package javaguide.java.basic.ch06BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Case05 {
    public static void main(String[] args) {
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(n);// 1.26
        BigDecimal n2 = m.setScale(3, RoundingMode.HALF_DOWN);
        System.out.println(n2);// 1.255
    }
}
