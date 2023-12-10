package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortTest {
    /**
     * Radix Sort
     */
    public static int[] radixSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int N = 1;
        int maxValue = arr[0];
        for (int element : arr) {
            if (element > maxValue) {
                maxValue = element;
            }
        }
        while (maxValue / 10 != 0) {
            maxValue = maxValue / 10;
            N += 1;
        }
        for (int i = 0; i < N; i++) {
            List<List<Integer>> radix = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                radix.add(new ArrayList<Integer>());
            }
            for (int element : arr) {
                int idx = (element / (int) Math.pow(10, i)) % 10;
                radix.get(idx).add(element);
            }
            int idx = 0;
            for (List<Integer> l : radix) {
                for (int n : l) {
                    arr[idx++] = n;
                }
            }
        }
        return arr;
    }

    @Test
    public void radixSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = radixSort(a);
        System.out.println(Arrays.toString(r));
    }
}