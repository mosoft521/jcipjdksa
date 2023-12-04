package javaguide.cs.ds;

import org.junit.jupiter.api.Test;

public class MyBloomFilterTest {
    @Test
    public void myBFTest1() {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));//false
        System.out.println(filter.contains(value2));//false
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));//true
        System.out.println(filter.contains(value2));//true
        System.out.println(filter.contains("http://www.baidu.com"));//false
    }

    @Test
    public void myBFTest2() {
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));//false
        System.out.println(filter.contains(value2));//false
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));//true
        System.out.println(filter.contains(value2));//true
        System.out.println(filter.contains(12345));//false
    }
}