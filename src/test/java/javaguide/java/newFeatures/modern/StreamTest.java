package javaguide.java.newFeatures.modern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    private List<String> stringList = new ArrayList<>();

    @BeforeEach
    private void be() {
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    @Test
    public void filterTest() {
        // 测试 Filter(过滤)
        stringList
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);//aaa2 aaa1
    }

    @Test
    public void sortedTest() {
        // 测试 Sort (排序)
        stringList
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// aaa1 aaa2
    }

    @Test
    public void sortedTest2() {
        // 测试 Sort (排序)
        stringList
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// aaa1 aaa2
        System.out.println(stringList);// [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
    }

    @Test
    public void mapTest() {
        // 测试 Map 操作
        stringList
                .stream()
                .map(String::toUpperCase)
//                .sorted((a, b) -> b.compareTo(a))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);// DDD2, DDD1, CCC, BBB3, BBB2, BBB1, AAA2, AAA1
        System.out.println(stringList);// [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
    }

    @Test
    public void matchTest() {
        // 测试 Match (匹配)操作
        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true
        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false
        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true
        System.out.println(stringList);// [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
    }

    @Test
    public void countTest() {
        //测试 Count (计数)操作
        long startsWithB =
                stringList
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);    // 3
        System.out.println(stringList);// [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
    }

    @Test
    public void reduceTest() {
        //测试 Reduce (规约)操作
        Optional<String> reduced =
                stringList
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2
        System.out.println(stringList);// [ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]
    }

    @Test
    public void reduceTest2() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和，sumValue = 10, 无起始值，默认为0
        int sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
        // 求和，sumValue = 110, 有起始值100
        sumValue = Stream.of(1, 2, 3, 4).reduce(100, Integer::sum);
        System.out.println(sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);
    }
}