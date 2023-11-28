package javaguide.java.collection.caution;

import java.util.Arrays;
import java.util.List;

public class Array2ListCaution {
    public static void main(String[] args) {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        //上面两个语句等价于下面一条语句
        List<String> myList2 = Arrays.asList("Apple", "Banana", "Orange");

        System.out.println(myList);
        System.out.println(myList2);
    }
}
/*
[Apple, Banana, Orange]
 */