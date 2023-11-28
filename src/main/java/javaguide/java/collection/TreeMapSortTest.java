package javaguide.java.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapSortTest {
    private Integer age;

    public TreeMapSortTest(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }


    public static void main(String[] args) {
        // v1
//        TreeMap<TreeMapSortTest, String> treeMap = new TreeMap<>(new Comparator<TreeMapSortTest>() {
//            @Override
//            public int compare(TreeMapSortTest o1, TreeMapSortTest o2) {
//                return Integer.compare(o1.getAge(), o2.getAge());
//            }
//        });
        //v2
//        TreeMap<TreeMapSortTest, String> treeMap = new TreeMap<>((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        //v3
        TreeMap<TreeMapSortTest, String> treeMap = new TreeMap<>(Comparator.comparingInt(TreeMapSortTest::getAge));
        treeMap.put(new TreeMapSortTest(3), "person1");
        treeMap.put(new TreeMapSortTest(18), "person2");
        treeMap.put(new TreeMapSortTest(35), "person3");
        treeMap.put(new TreeMapSortTest(16), "person4");
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
    }
}
/*
person1
person4
person2
person3
 */