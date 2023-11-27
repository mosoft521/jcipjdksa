package javaguide.java.basic.ch07Unsafe;

import lombok.Data;

@Data
public class APrivateConstructor {
    private int b;

    private APrivateConstructor() {
        this.b = 1;
    }
}