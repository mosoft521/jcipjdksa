package generics1;

import java.util.ArrayList;
import java.util.List;

public class GenericTest5 {
    private static <T> void test(List<? super T> dst, List<T> src) {
        for (T t : src) {
            dst.add(t);
        }
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        test(fruits, apples);
    }
}