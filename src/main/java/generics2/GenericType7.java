package generics2;

import java.util.ArrayList;

public class GenericType7 {
    public static void main(String[] args) {
        // ArrayList<Number> list01 = new ArrayList<Integer>();// 编译错误

        ArrayList<? extends Number> list02 = new ArrayList<Integer>();// 编译正确
    }
}