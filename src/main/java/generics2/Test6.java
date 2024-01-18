package generics2;

import java.util.ArrayList;

public class Test6 {
    public static void main(String[] args) {
        // 创建一个 ArrayList<? super Number> 集合
        ArrayList<Number> list = new ArrayList();
        // 往集合中添加 Number 类及其子类对象
        list.add(1);
        list.add(1.1);
        // 调用 fillNumList() 方法，传入 ArrayList<Number> 集合
        fillNumList(list);
        System.out.println(list);
    }

    public static void fillNumList(ArrayList<? super Number> list) {
        list.add(0);
        list.add(1.0);
    }
}