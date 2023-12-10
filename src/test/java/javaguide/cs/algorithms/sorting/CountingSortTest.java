package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountingSortTest {
    /**
     * Gets the maximum and minimum values in the array
     */
    private static int[] getMinAndMax(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return new int[]{minValue, maxValue};
    }

    /**
     * Counting Sort
     */
    public static int[] countingSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];
        int[] countArr = new int[maxValue - minValue + 1];
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - minValue] += 1;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = countArr[arr[i] - minValue] - 1;
            result[idx] = arr[i];
            countArr[arr[i] - minValue] -= 1;
        }
        return result;
    }

    @Test
    public void countingSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = countingSort(a);
        System.out.println(Arrays.toString(r));
    }
}