package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTest {
    /**
     * 插入排序
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    @Test
    public void insertionSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = insertionSort(a);
        System.out.println(Arrays.toString(r));
    }
}