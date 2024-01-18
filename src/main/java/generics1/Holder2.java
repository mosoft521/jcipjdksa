package generics1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holder2 {
    private Object a;

    public static void main(String[] args) {
        Holder2 holder2 = new Holder2(new Automobile());
        // 强制转换
        Automobile automobile = (Automobile) holder2.getA();
        holder2.setA("测试泛型");
        String s = (String) holder2.getA();
    }
}