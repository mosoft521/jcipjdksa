package javaguide.java.basic.ch09SyntacticSugar;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest3 {
    public static void main(String... args) {
        List<String> strList = ImmutableList.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com");

        List HollisList = strList.stream().filter(string -> string.contains("Hollis")).collect(Collectors.toList());

        HollisList.forEach(s -> {
            System.out.println(s);
        });
    }
}
/*
Hollis
公众号：Hollis
 */