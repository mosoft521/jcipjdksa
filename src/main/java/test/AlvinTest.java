package test;

public class AlvinTest {
    public static void main(String[] args) {
        System.out.println(Long.MIN_VALUE);//-9223372036854775808
        System.out.println(Long.MAX_VALUE);//9223372036854775807
        long l1 = Long.MAX_VALUE;
        long l2 = l1 + 1;
        System.out.println(l2); // -9223372036854775808
        System.out.println(l2 == Long.MIN_VALUE); // true
        System.out.println(l1 < l2);// false

        System.out.println(42 == 42.0);// true
    }
}
