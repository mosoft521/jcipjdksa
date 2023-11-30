package javaguide.java.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int temvalue = 0;
        int[] nums = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }
        temvalue = i.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
        temvalue = i.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);
    }
}
/*
1
2
3
4
5
6
temvalue:1;  i:[2, 2, 3, 4, 5, 6]
temvalue:2;  i:[3, 2, 3, 4, 5, 6]
temvalue:3;  i:[8, 2, 3, 4, 5, 6]

Process finished with exit code 0
 */