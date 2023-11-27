package javaguide.java.basic.ch09SyntacticSugar;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> strList = ImmutableList.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com");

        strList.forEach(s -> {
            System.out.println(s);
        });
    }
}