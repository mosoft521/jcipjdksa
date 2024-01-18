package generics2;

import java.util.ArrayList;

public class GenericType12 {
    public static void main(String[] args) {
        ArrayList<?> list = new ArrayList<>();
        list.add(null);// 编译正确
        Object obj = list.get(0);// 编译正确

        // list.add(new Integer(1));// 编译错误
        // list.add(1);// 编译错误
        // Integer num = list.get(0);// 编译错误
    }
}