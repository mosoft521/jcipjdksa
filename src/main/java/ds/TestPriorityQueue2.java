package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/asad21654864/article/details/128664685
 */
public class TestPriorityQueue2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2 - o1);
        p.offer(4);
        p.offer(3);
        p.offer(2);
        p.offer(1);
        p.offer(5);
        List<Integer> newStrList = new ArrayList<>(p);
        System.out.println(newStrList); // [5, 4, 2, 1, 3]

        p.stream().collect(Collectors.toList()).forEach(System.out::print); // 54213
        System.out.println();
        new ArrayList<>(p).forEach(System.out::print); // 54213
        System.out.println();
        new ArrayList<>(p).forEach(s -> System.out.print(s + ",")); // 5,4,2,1,3,
        System.out.println();

        Integer i;
        while ((i = p.poll()) != null) {
            System.out.print(i); // ok: 54321
        }
    }
}
