package javaguide.java.newFeatures.modern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private Map<Integer, String> map = new HashMap<>();

    @BeforeEach
    private void be() {
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
    }

    @Test
    public void mapPutIfAbsentTest() {
        map.forEach((id, val) -> System.out.println(val));//val0 val1 val2 val3 val4 val5 val6 val7 val8 val9
    }

    @Test
    public void mapComputeIfPresentTest() {
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));// val33
        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));// false
        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));// true
        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));// val33
    }

    @Test
    public void mapRemoveTest() {
        map.remove(3, "xxx");
        System.out.println(map.get(3)); // val3
        map.remove(3, "val3");
        System.out.println(map.get(3)); // null
    }

    @Test
    public void getOrDefaultTest() {
        System.out.println(map.getOrDefault(42, "not found")); // not found
    }

    @Test
    public void mergeTest() {
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9val9
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9val9concat
    }
}