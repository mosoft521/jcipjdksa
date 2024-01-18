package generics2;

import java.util.ArrayList;

public class GenericType9 {
    public static void main(String[] args) {
        // ArrayList<Integer> list01 = new ArrayList<Number>();// 编译错误

        ArrayList<? super Integer> list02 = new ArrayList<Number>();// 编译正确
    }
}