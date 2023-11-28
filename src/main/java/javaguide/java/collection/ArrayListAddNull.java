package javaguide.java.collection;

import java.util.ArrayList;

public class ArrayListAddNull {
    public static void main(String[] args) {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add(null);
        listOfStrings.add("java");
        System.out.println(listOfStrings);
    }
}
/*
[null, java]
 */