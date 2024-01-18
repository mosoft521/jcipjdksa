package generics1;

import java.util.Random;

public class NumberGenerator implements Generator<Integer> {

    @Override
    public Integer next() {
        return new Random().nextInt();
    }
}
