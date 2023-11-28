package javaguide.java.collection.caution;

import java.util.ArrayList;
import java.util.List;

public class Array2ListUseHandMethod {

    //JDK1.5+
    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<T>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] myArray = {1, 2, 3};
        System.out.println(arrayToList(myArray).getClass());//class java.util.ArrayList
    }
}