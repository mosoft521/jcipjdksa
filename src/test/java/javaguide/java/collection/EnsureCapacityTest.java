package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EnsureCapacityTest {
    @Test
    public void ensureCapacityTest01() {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));
    }

    @Test
    public void ensureCapacityTest02() {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后：" + (endTime1 - startTime1));
    }
}
/*
使用ensureCapacity方法前：527
使用ensureCapacity方法后：437
 */