package javaguide.java.basic.javaBasicQuestions02;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class PersonWithLombok implements Serializable {

    @NonNull
    private AddressWithLombok address;
}