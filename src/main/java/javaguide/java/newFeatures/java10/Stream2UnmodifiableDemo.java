package javaguide.java.newFeatures.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream2UnmodifiableDemo {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("aa");
        list.add("11");
        System.out.println(list);//[aa, 11]
//        List list1 = list.stream().collect(Collectors.toUnmodifiableList());
        List<String> list1 = list.stream().toList();
//        list1.add("bb");//Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list1);//[aa, 11]
        Set<String> set1 = list.stream().collect(Collectors.toUnmodifiableSet());
//        set1.add("cc");//Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(set1);//[aa, 11]
    }
}