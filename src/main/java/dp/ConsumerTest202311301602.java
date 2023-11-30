package dp;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerTest202311301602 {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println(s.length());
        Arrays.asList("ab", "abc", "a", "abcd").stream().forEach(stringConsumer);
    }
}
/*
2
3
1
4
 */