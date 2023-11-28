package javaguide.java.collection.caution;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2ListUseGuava2 {

    public static void main(String[] args) {
        List<String> anotherListOrCollection = new ArrayList<>(Arrays.asList("a", "b", "c"));
        String[] aStringArray = {"a", "b", "c"};
        List<String> l1 = Lists.newArrayList(anotherListOrCollection);    // from collection
        List<String> l2 = Lists.newArrayList(aStringArray);               // from array
        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
    }
}