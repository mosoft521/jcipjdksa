package javaguide.java.newFeatures.java14;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void sTest() {
        String str = "凡心所向，素履所往，生如逆旅，一苇以航。";

        String str2 = """
                凡心所向，素履所往， \
                生如逆旅，一苇以航。""";
        System.out.println(str2);// 凡心所向，素履所往， 生如逆旅，一苇以航。
        String text = """
                java
                c++\sphp
                """;
        System.out.println(text);
    }
}
/*
凡心所向，素履所往， 生如逆旅，一苇以航。
java
c++ php
 */