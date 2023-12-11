package javaguide.java.collection;

import org.junit.jupiter.api.Test;

public class SystemArraycopyTest {
    @Test
    public void arrayCopyTest() {
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        a[2] = 99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
/*
0 1 99 2 3 0 0 0 0 0
 */