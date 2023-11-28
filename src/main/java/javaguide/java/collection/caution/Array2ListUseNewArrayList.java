package javaguide.java.collection.caution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2ListUseNewArrayList {

    public static void main(String[] args) {
        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    }
}