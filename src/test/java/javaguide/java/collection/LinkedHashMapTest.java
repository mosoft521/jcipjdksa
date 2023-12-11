package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    /**
     * 插入顺序遍历
     * a:2
     * g:3
     * r:1
     * e:23
     */
    @Test
    public void test01() {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("a", "2");
        map.put("g", "3");
        map.put("r", "1");
        map.put("e", "23");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 访问顺序遍历
     * 1 : one
     * 4 : four
     * 5 : five
     * 2 : two
     * 3 : three
     */
    @Test
    public void test02() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        //访问元素2,该元素会被移动至链表末端
        map.get(2);
        //访问元素3,该元素会被移动至链表末端
        map.get(3);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
