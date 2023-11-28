package javaguide.java.collection.caution;

import java.util.Arrays;
import java.util.List;

public class Array2ListCaution3 {
    public static void main(String[] args) {
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//3
        System.out.println(myList.get(0));//1
        System.out.println(myList.get(1));//2
    }
}