package javaguide.java.newFeatures.modern;

import java.util.Arrays;
import java.util.List;

public class StringArraysSortNew {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

//        Collections.sort(names, (String a, String b) -> {
//            return b.compareTo(a);
//        });

//        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        names.sort((a, b) -> b.compareTo(a));

        System.out.println(names);//[xenia, peter, mike, anna]
    }
}