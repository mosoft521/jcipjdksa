package generics1;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    public int getWeigth() {
        return 0;
    }
}

// Apple是水果Fruit类的子类
class Apple extends Fruit {
    public int getWeigth() {
        return 5;
    }
}

public class GenericTest {
    // 数组的传参
    static int sumWeigth(Fruit[] fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    static int sumWeight1(List<? extends Fruit> fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    static int sumWeigth2(List<Fruit> fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        sumWeigth(fruits);
        List<Apple> apples = new ArrayList<>();
        sumWeight1(apples);
        // 下行编译报错
        // sumWeigth2(apples);
    }
}