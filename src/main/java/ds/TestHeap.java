package ds;

import java.util.Arrays;

/**
 * 小根堆
 * https://blog.csdn.net/asad21654864/article/details/128664685
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    public void createHeap() {
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 小根堆
     * 向下调整
     */
    private void shiftDown(int parent, final int len) {
        int child = 2 * parent + 1;
        //最起码 要有左孩子
        while (child < len) {
            //一定是有右孩子的情况下
            if (child + 1 < len && elem[child] > elem[child + 1]) {
                child++;
            }
            //child下标 一定是左右孩子 最小值的下标
            if (elem[child] < elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /**
     * @Description： //向上调整建堆的时间复杂度：N*logN
     */
    public void offer(int val) {
        if (isFull()) {
            //扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
        //向上调整
        shiftUp(usedSize - 1);
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] < elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new NullPointerException("堆为空");
        }
        int r = elem[0];
        swap(elem, 0, --usedSize);
        shiftDown(0, usedSize);
        return r;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        TestHeap testHeap = new TestHeap();
        testHeap.initElem(ints);
        testHeap.createHeap();
        testHeap.offer(10);
        testHeap.offer(1);
        for (int i = 0; i < testHeap.elem.length; i++) {
            System.out.println(i + ": " + testHeap.pop());
        }
        System.out.println(testHeap.pop());
    }
}
/*
0: 1
1: 10
2: 15
3: 18
4: 19
5: 25
6: 27
7: 28
8: 34
9: 37
10: 49
11: 65
Exception in thread "main" java.lang.NullPointerException: 堆为空
	at ds.TestHeap.pop(TestHeap.java:88)
	at ds.TestHeap.main(TestHeap.java:114)
 */