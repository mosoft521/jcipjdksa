package javaguide.java.newFeatures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void test() {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        //返回符合条件的stream
        Stream<String> stringStream = strings.stream().filter(s -> "abc".equals(s));
        //stringStream.forEach(System.out::println);//abc abc
        //计算流符合条件的流的数量
        long count = stringStream.count();
        System.out.println(count); // 2

        //forEach遍历->打印元素
        strings.stream().forEach(System.out::println);//abc def gkh abc

        //limit 获取到1个元素的stream
        Stream<String> limit = strings.stream().limit(1);
        //toArray 比如我们想看这个limitStream里面是什么，比如转换成String[],比如循环
        String[] array = limit.toArray(String[]::new);
        System.out.println(Arrays.toString(array)); // [abc]

        //map 对每个元素进行操作返回新流
        Stream<String> map = strings.stream().map(s -> s + "22");
        map.forEach(System.out::println);//abc22 def22 gkh22 abc22

        //sorted 排序并打印
        strings.stream().sorted().forEach(System.out::println);// abc abc def gkh

        //Collectors collect 把abc放入容器中
        List<String> collect = strings.stream().filter(string -> "abc".equals(string)).collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));//[abc, abc]
        //把list转为string，各元素用，号隔开
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println(mergedString);//abc,def,gkh,abc
        //对数组的统计，比如用
        List<Integer> number = Arrays.asList(1, 2, 5, 4);
        System.out.println(number.toString());//[1, 2, 5, 4]

        IntSummaryStatistics statistics = number.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + statistics.getMax());//列表中最大的数 : 5
        System.out.println("列表中最小的数 : " + statistics.getMin());//列表中最小的数 : 1
        System.out.println("平均数 : " + statistics.getAverage());//平均数 : 3.0
        System.out.println("所有数之和 : " + statistics.getSum());//所有数之和 : 12

        //concat 合并流
        List<String> strings2 = Arrays.asList("xyz", "jqx");
        long count2 = Stream.concat(strings2.stream(), strings.stream()).count();
        System.out.println(count2);//6

        //注意 一个Stream只能操作一次，不能断开，否则会报错。
        Stream stream = strings.stream();
        //第一次使用
        //stream.limit(2);
        //第二次使用
        //stream.forEach(System.out::println);
        //报错 java.lang.IllegalStateException: stream has already been operated upon or closed

        //但是可以这样, 连续使用
        stream.limit(2).forEach(System.out::println);//abc def
    }

    @Test
    public void laziness() {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        Stream<Integer> stream = strings.stream().filter(new Predicate() {
            @Override
            public boolean test(Object o) {
                System.out.println("Predicate.test 执行");
                return true;
            }
        });
        System.out.println("count 执行");
        stream.count();
    }
    /*
    count 执行
    Predicate.test 执行
    Predicate.test 执行
    Predicate.test 执行
    Predicate.test 执行
     */

    @Test
    public void parallelStreamTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 4);
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            numbers.add(i);
//        }
        numbers.parallelStream().forEach(num -> System.out.println(Thread.currentThread().getName() + ">>" + num));
    }
    /*
    main>>5
    ForkJoinPool.commonPool-worker-2>>4
    ForkJoinPool.commonPool-worker-11>>1
    ForkJoinPool.commonPool-worker-9>>2
     */
}