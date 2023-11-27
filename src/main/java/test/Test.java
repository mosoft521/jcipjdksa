package test;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> stringList = ImmutableList.of("awe", "coder");
        stringList.forEach(e -> {
            System.out.println(e);
        });
    }
}