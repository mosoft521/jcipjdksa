package generics2;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericType11 {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<Integer>(Arrays.asList(123, 456));
        ArrayList<?> list02 = list01; // 安全地向上转型
    }
}