package generics1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 常见的如T、E、K、V等形式的参数常用于表示泛型，编译时无法知道它们类型，实例化时需要指定。
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair<K, V> {

    private K first;
    private V second;

    public static void main(String[] args) {
        // 此处K传入了Integer，V传入String类型
        Pair<Integer, String> pairInteger = new Pair<>(1, "第二");
        System.out.println("泛型测试，first is " + pairInteger.getFirst()
                + " ,second is " + pairInteger.getSecond());
    }
}
/*
泛型测试，first is 1 ,second is 第二
 */