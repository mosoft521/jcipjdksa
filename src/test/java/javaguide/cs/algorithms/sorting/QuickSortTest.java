package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSortTest {
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            //compare
            if (array[i] <= pivot) {
                //swap
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            //System.out.println(Arrays.toString(array));
        }
        //swap
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    @Test
    public void quickSortTest() {
        int[] a = new int[]{3, 9, 1, 8, 2, 7, 5, 6, 4};
        quickSort(a);
        System.out.println("#####");
        System.out.println(Arrays.toString(a));//[1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}