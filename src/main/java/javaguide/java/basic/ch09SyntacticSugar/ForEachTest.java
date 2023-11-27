package javaguide.java.basic.ch09SyntacticSugar;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class ForEachTest {
    public static void main(String... args) {
        String[] strs = {"Hollis", "公众号：Hollis", "博客：www.hollischuang.com"};
        for (String s : strs) {
            System.out.println(s);
        }
        List<String> strList = ImmutableList.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com");
        for (String s : strList) {
            System.out.println(s);
        }
    }
}