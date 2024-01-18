package generics2;

import java.util.ArrayList;

public class Test7 {
    public static void main(String[] args) {
        // 创建一个 ArrayList<Integer> 集合
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        // 调用 fillNumList() 方法，传入 ArrayList<Integer> 集合
        // fillNumList(list);// 编译错误
    }

    public static void fillNumList(ArrayList<? super Number> list) {// 下界：Number
        list.add(0);// 编译正确
        list.add(1.0);// 编译正确

        // 遍历传入集合中的元素，并赋值给 Number 对象；会编译错误
        // for (Number number : list) {
        //     System.out.print(number.intValue() + " ");
        //     System.out.println();
        // }
        // 遍历传入集合中的元素，并赋值给 Object 对象；可以正确编译
        // 但只能调用 Object 类的方法，不建议这样使用
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}