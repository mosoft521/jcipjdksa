package generics1;

import java.util.ArrayList;
import java.util.List;

public class GenericTest3 {
    static int sumWeight1(List<? extends Fruit> fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        System.out.println(sumWeight1(apples));// 10
    }
}