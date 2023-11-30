package javaguide.java.concurrent;

public class ThreadLocalDemoNextHashcode {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        int hashCode = 0;
        for (int i = 0; i < 16; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int bucket = hashCode & 15;
            System.out.println(i + "\t在桶中的位置：\t" + bucket);
        }
    }
}
/*
0	在桶中的位置：	7
1	在桶中的位置：	14
2	在桶中的位置：	5
3	在桶中的位置：	12
4	在桶中的位置：	3
5	在桶中的位置：	10
6	在桶中的位置：	1
7	在桶中的位置：	8
8	在桶中的位置：	15
9	在桶中的位置：	6
10	在桶中的位置：	13
11	在桶中的位置：	4
12	在桶中的位置：	11
13	在桶中的位置：	2
14	在桶中的位置：	9
15	在桶中的位置：	0
 */