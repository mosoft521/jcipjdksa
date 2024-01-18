package generics1;

import java.util.ArrayList;
import java.util.List;

public class GenericTest4 {
    static int sumWeight1(List<? extends Fruit> fruits) {
        // fruits.add(new Fruit());// 报错：java: 不兼容的类型: generics1.Fruit无法转换为capture#1, 共 ? extends generics1.Fruit
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