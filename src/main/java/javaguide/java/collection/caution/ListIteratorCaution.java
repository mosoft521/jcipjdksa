package javaguide.java.collection.caution;

import java.util.ArrayList;
import java.util.List;

public class ListIteratorCaution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
        System.out.println(list); /* [1, 3, 5, 7, 9] */
    }
}