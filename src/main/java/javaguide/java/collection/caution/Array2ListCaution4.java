package javaguide.java.collection.caution;

import java.util.Arrays;
import java.util.List;

public class Array2ListCaution4 {
    public static void main(String[] args) {
        List myList = Arrays.asList(1, 2, 3);
        System.out.println(myList.getClass());//class java.util.Arrays$ArrayList
        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException
    }
}