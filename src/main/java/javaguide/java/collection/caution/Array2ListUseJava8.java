package javaguide.java.collection.caution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array2ListUseJava8 {

    public static void main(String[] args) {
        // Java8
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        List myList2 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());

        System.out.println(myList);
        System.out.println(myList2);
    }
}