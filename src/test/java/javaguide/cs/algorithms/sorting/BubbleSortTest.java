package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {
    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Set a flag, if true, that means the loop has not been swapped,
            // that is, the sequence has been ordered, the sorting has been completed.
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                //compare
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    @Test
    public void bubbleSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        int[] r = bubbleSort(a);
        System.out.println(Arrays.toString(r));
    }
}