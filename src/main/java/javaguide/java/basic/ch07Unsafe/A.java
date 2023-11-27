package javaguide.java.basic.ch07Unsafe;

import lombok.Data;

@Data
public class A {
    private int b;

    public A() {
        this.b = 1;
    }
}