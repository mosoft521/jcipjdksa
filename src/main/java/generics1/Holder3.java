package generics1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holder3<T> {

    private T a;

    public static void main(String[] args) {
        Holder3<Automobile> holder3 = new Holder3<>(new Automobile());
        Automobile automobile = holder3.getA();
    }
}