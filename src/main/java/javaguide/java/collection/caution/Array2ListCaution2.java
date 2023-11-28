package javaguide.java.collection.caution;

import java.util.Arrays;
import java.util.List;

public class Array2ListCaution2 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值 [I@49476842
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
    }
}
