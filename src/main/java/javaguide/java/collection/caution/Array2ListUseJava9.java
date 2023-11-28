package javaguide.java.collection.caution;

import java.util.List;

public class Array2ListUseJava9 {

    public static void main(String[] args) {
        // Java9
        Integer[] array = {1, 2, 3};
        List<Integer> list = List.of(array);
        System.out.println(list);
    }
}