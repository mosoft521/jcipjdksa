package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class LRUCacheTest {
    @Test
    public void lruCacheTest() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");
        for (int i = 0; i < 5; i++) {
            System.out.println(cache.get(i));
        }
        System.out.println("#####");
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
/*
null
null
null
three
four
#####
3:three
4:four
 */