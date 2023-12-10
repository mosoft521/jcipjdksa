package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    /**
     * 归并排序
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(arr_1), mergeSort(arr_2));
    }

    /**
     * Merge two sorted arrays
     * @return sorted_arr
     */
    public static int[] merge(int[] arr_1, int[] arr_2) {
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        int idx = 0, idx_1 = 0, idx_2 = 0;
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            if (arr_1[idx_1] < arr_2[idx_2]) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
            } else {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
            }
            idx += 1;
        }
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
                idx += 1;
            }
        } else {
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
                idx += 1;
            }
        }
        return sorted_arr;
    }

    @Test
    public void mergeSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = mergeSort(a);
        System.out.println(Arrays.toString(r));
    }
}