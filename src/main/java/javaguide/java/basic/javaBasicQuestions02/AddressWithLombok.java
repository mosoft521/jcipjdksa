package javaguide.java.basic.javaBasicQuestions02;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class AddressWithLombok implements Serializable {
    @NonNull
    private String name;
}