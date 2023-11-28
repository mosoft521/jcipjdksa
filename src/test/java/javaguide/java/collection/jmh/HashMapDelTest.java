package javaguide.java.collection.jmh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s/zQBN3UvJDhRTKP6SzcZFKw
 */
public class HashMapDelTest {
    private static HashMap<Integer, String> map = new HashMap();

    @BeforeEach
    public void init() {
        map.put(0, "000");
        map.put(1, "111");
        map.put(2, "222");
    }

    /**
     * show:0
     * del:1
     * show:2
     */
    @Test
    public void iteratorTestOk() {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getKey() == 1) {
                // 删除
                System.out.println("del:" + entry.getKey());
                iterator.remove();
            } else {
                System.out.println("show:" + entry.getKey());
            }
        }
    }

    /**
     * show:0
     * del:1
     *
     * java.util.ConcurrentModificationException
     */
    @Test
    public void forTestErr() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 1) {
                // 删除
                System.out.println("del:" + entry.getKey());
                map.remove(entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        }
    }

    /**
     * show:0
     * del:1
     * show:2
     *
     * java.util.ConcurrentModificationException
     */
    @Test
    public void lambdaTestErr() {
        map.forEach((key, value) -> {
            if (key == 1) {
                System.out.println("del:" + key);
                map.remove(key);
            } else {
                System.out.println("show:" + key);
            }
        });
    }

    /**
     * show:0
     * show:2
     */
    @Test
    public void lambdaTestOk() {
        // 根据 map 中的 key 去判断删除
        map.keySet().removeIf(key -> key == 1);
        map.forEach((key, value) -> {
            System.out.println("show:" + key);
        });
    }

    /**
     * show:0
     * del:1
     * show:2
     *
     * java.util.ConcurrentModificationException
     */
    @Test
    public void streamTestErr() {
        map.entrySet().stream().forEach((entry) -> {
            if (entry.getKey() == 1) {
                System.out.println("del:" + entry.getKey());
                map.remove(entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        });
    }

    /**
     * show:0
     * show:2
     */
    @Test
    public void streamTestOk() {
        map.entrySet().stream().filter(m -> 1 != m.getKey()).forEach((entry) -> {
            if (entry.getKey() == 1) {
                System.out.println("del:" + entry.getKey());
            } else {
                System.out.println("show:" + entry.getKey());
            }
        });
    }
}