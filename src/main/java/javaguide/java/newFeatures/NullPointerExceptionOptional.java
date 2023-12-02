package javaguide.java.newFeatures;

import lombok.Data;

import java.util.Optional;

@Data
public class NullPointerExceptionOptional {

    private Zoo zoo;

    public static void main(String[] args) {
        //init
        NullPointerExceptionOptional nullPointerExceptionOptional = new NullPointerExceptionOptional();
        Zoo zoo = new Zoo();
        nullPointerExceptionOptional.setZoo(zoo);
        Dog dog2 = new Dog();
        dog2.setAge(8);
        zoo.setDog(dog2);

        Optional.ofNullable(nullPointerExceptionOptional.getZoo()).map(o -> o.getDog()).map(d -> d.getAge()).ifPresent(age -> System.out.println(age));
    }
}