package javaguide.java.newFeatures.modern;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
//        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> predicate = s -> !s.isEmpty();

        System.out.println(predicate.test("foo")); // true
        System.out.println(predicate.negate().test("foo")); // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println(nonNull.test(null));//false
//        nonNull.test("");//err
//        nonNull.test("null");//err
        System.out.println(isNull.test(null));// true
//        isNull.test("");//err
//        isNull.test("null");//err

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        //isEmpty.test(null);//err
        System.out.println(isEmpty.test(""));//true
        System.out.println(isEmpty.test("null"));//false
        //isNotEmpty.test(null);//err
        System.out.println(isNotEmpty.test(""));//false
        System.out.println(isNotEmpty.test("null"));// true
    }
}