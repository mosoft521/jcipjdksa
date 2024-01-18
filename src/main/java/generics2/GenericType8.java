package generics2;

import java.util.ArrayList;

public class GenericType8 {
    public static void main(String[] args) {
        ArrayList<? extends Number> list = new ArrayList<>();

        // list.add(new Integer(1));// 编译错误
        // list.add(new Float(1.0));// 编译错误
    }
}