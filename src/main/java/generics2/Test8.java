package generics2;

import java.util.ArrayList;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        // 创建一个 ArrayList<String> 集合
        List<String> list = new ArrayList();

        fillList(list);// 编译正确
        // fillObjList(list);// 编译错误
    }

    public static void fillList(List list) {
        // ...
    }

    public static void fillObjList(List<Object> list) {
        //...
    }
}