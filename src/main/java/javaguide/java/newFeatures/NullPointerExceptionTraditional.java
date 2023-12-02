package javaguide.java.newFeatures;

import lombok.Data;

@Data
public class NullPointerExceptionTraditional {

    private Zoo zoo;

    public static void main(String[] args) {
        //init
        NullPointerExceptionTraditional nullPointerExceptionTraditional = new NullPointerExceptionTraditional();
        Zoo zoo = new Zoo();
        nullPointerExceptionTraditional.setZoo(zoo);
        Dog dog2 = new Dog();
        dog2.setAge(8);
        zoo.setDog(dog2);

        //NPE Test
        if (zoo != null) {
            Dog dog = zoo.getDog();
            if (dog != null) {
                int age = dog.getAge();
                System.out.println(age);
            }
        }
    }
}