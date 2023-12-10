package javaguide.cs.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSortTest {
    /**
     * Gets the maximum and minimum values in the array
     */
    private static int[] getMinAndMax(List<Integer> arr) {
        int maxValue = arr.get(0);
        int minValue = arr.get(0);
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            } else if (i < minValue) {
                minValue = i;
            }
        }
        return new int[]{minValue, maxValue};
    }

    /**
     * Bucket Sort
     */
    public static List<Integer> bucketSort(List<Integer> arr, int bucket_size) {
        if (arr.size() < 2 || bucket_size == 0) {
            return arr;
        }
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];
        int bucket_cnt = (maxValue - minValue) / bucket_size + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucket_cnt; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for (int element : arr) {
            int idx = (element - minValue) / bucket_size;
            buckets.get(idx).add(element);
        }
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).size() > 1) {
                buckets.set(i, bucketSort(buckets.get(i), bucket_size / 2));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            for (int element : bucket) {
                result.add(element);
            }
        }
        return result;
    }

    @Test
    public void bucketSortTest() {
        // Java9
        Integer[] a = {3, 9, 1, 8, 2, 7, 5, 6, 4};
        List<Integer> lia = List.of(a);
        List<Integer> r = bucketSort(lia, 5);
        System.out.println(Arrays.toString(r.toArray()));
    }
}