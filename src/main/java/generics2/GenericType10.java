package generics2;

import java.util.ArrayList;

public class GenericType10 {
    public static void main(String[] args) {
        ArrayList<? super Number> list = new ArrayList<>();

        list.add(1);// 编译正确
        list.add(1.0F);// 编译正确

        // Object 是 Number 的父类
        // list.add(new Object());// 编译错误
    }
}