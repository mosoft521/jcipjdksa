package javaguide.java.newFeatures.java11;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        var op = Optional.empty();
        System.out.println(op.isEmpty());//判断指定的 Optional 对象是否为空 true
    }
}