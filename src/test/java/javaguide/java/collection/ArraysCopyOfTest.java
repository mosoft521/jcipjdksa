package javaguide.java.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraysCopyOfTest {
    @Test
    public void copyOfTest() {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println("b.length: " + b.length);
        System.out.println(Arrays.toString(b));
    }
}
/*
b.length: 10
[0, 1, 2, 0, 0, 0, 0, 0, 0, 0]
 */