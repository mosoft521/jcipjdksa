package ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://blog.csdn.net/asad21654864/article/details/128664685
 */
class Solution {
    public static int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }

        //Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1)); //求解最小的topK，搞个大根堆
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //求解最小的topK，搞个大根堆
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int val = maxHeap.peek();
            if (val > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[k - i - 1] = maxHeap.poll();//弹出时，倒序存到返回数组里
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] rs = Solution.smallestK(ints, 4);
        System.out.println(Arrays.toString(rs)); //[1, 2, 3, 4]
    }
}
