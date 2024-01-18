package generics2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Generics2Test {
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }

    @Test
    @Disabled
    public void test2() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(111);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));// java.lang.ClassCastException
        }
    }

    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        // list.add(111);// 在编译阶段，编译器会报错
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }


}