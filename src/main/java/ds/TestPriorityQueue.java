package ds;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://blog.csdn.net/asad21654864/article/details/128664685
 * 用户自己定义的比较器：直接实现Comparator接口，然后重写该接口中的compare方法即可
 */
class IntCmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>(new IntCmp());
        p.offer(4);
        p.offer(3);
        p.offer(2);
        p.offer(1);
        p.offer(5);
        int count = p.size();
        for (int i = 0; i < count; i++) {
            System.out.println(p.poll());
        }
    }
}
/*
5
4
3
2
1
 */