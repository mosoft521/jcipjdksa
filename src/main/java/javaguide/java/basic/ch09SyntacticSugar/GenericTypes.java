package javaguide.java.basic.ch09SyntacticSugar;

import java.util.List;

/**
 * 'method(List<String>)' clashes with 'method(List<Integer>)'; both methods have same erasure
 */
public class GenericTypes {

    public static void method(List<String> list) {
        System.out.println("invoke method(List<String> list)");
    }

//    public static void method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//    }
}