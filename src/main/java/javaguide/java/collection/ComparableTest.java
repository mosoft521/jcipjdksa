package javaguide.java.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.TreeMap;

// ComparableTest对象没有实现Comparable接口，所以必须实现，这样才不会出错，才可以使TreeMap中的数据按顺序排列
// 前面一个例子的String类已经默认实现了Comparable接口，详细可以查看String类的API文档，另外其他
// 像Integer类等都已经实现了Comparable接口，所以不需要另外实现了
@Getter
@Setter
public class ComparableTest implements Comparable<ComparableTest> {
    private String name;
    private int age;

    public ComparableTest(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 重写compareTo方法实现按年龄来排序
     */
    @Override
    public int compareTo(ComparableTest o) {
//        if (this.age > o.getAge()) {
//            return 1;
//        }
//        if (this.age < o.getAge()) {
//            return -1;
//        }
//        return 0;
        return Integer.compare(this.age, o.getAge());
    }

    public static void main(String[] args) {
        TreeMap<ComparableTest, String> treeMap = new TreeMap<>();
        treeMap.put(new ComparableTest("张三", 30), "zhangsan");
        treeMap.put(new ComparableTest("李四", 20), "lisi");
        treeMap.put(new ComparableTest("王五", 10), "wangwu");
        treeMap.put(new ComparableTest("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<ComparableTest> keys = treeMap.keySet();
        for (ComparableTest key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());
        }
    }
}
/*
5-小红
10-王五
20-李四
30-张三
 */