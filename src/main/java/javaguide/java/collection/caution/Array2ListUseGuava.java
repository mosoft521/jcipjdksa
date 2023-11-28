package javaguide.java.collection.caution;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Array2ListUseGuava {

    public static void main(String[] args) {
        String[] aStringArray = {"a", "b", "c"};
        List<String> il = ImmutableList.of("string", "elements");  // from varargs
        List<String> sl = ImmutableList.copyOf(aStringArray);      // from array
    }
}