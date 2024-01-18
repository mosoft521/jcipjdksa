package generics1;

import java.util.ArrayList;
import java.util.List;

public class GenericTest2 {
    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        List<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(666);
        // 报错，List<?>不能添加任何类型
        List<?> list3 = new ArrayList<>();
        // 编译报错：java: 不兼容的类型: int无法转换为capture#1, 共 ?
        // list3.add(666);
    }
}