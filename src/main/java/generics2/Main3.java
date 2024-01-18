package generics2;

public class Main3 {
    public static void main(String[] args) {
        Pair<Integer> pairInteger = new Pair<>(123, 456);
        int sum = PairHelper2.addPair(pairInteger);
    }
}