package interview.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RadixSortTest extends IArraySortTest {
    private static RadixSort radixSort;

    @BeforeAll
    public static void initRadixSort() {
        radixSort = new RadixSort();
    }

    @Test
    public void radixSortTest() throws Exception {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = radixSort.sort(a);
        Assertions.assertEquals(r.length, a.length);
        Assertions.assertEquals(9, r.length);
        int[] expecteds = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(expecteds, r);
    }
}