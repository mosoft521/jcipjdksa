package javaguide.java.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MyClass implements Serializable {
    private String name;
    private String desc;
}
