package generics2;

public class Main1 {
    public static void main(String[] args) {
        Pair<Number> pair = new Pair<>(1, 2);
        int sum = PairHelper.addPair(pair);
    }
}