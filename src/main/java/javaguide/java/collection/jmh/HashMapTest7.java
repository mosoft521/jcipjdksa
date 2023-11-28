package javaguide.java.collection.jmh;

import java.util.HashMap;
import java.util.Map;

/**
 * Streams API 多线程
 */
public class HashMapTest7 {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
/*
4
MyBatis framework
1
Java
2
JDK
5
Java中文社群
3
Spring Framework
####################
4
1
Java
MyBatis framework
2
JDK
5
Java中文社群
3
Spring Framework
 */