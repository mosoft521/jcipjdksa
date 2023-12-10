package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShellSortTest {
    /**
     * 希尔排序
     */
    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                // Insertion sort
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return arr;
    }

    @Test
    public void shellSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = shellSort(a);
        System.out.println(Arrays.toString(r));
    }
}