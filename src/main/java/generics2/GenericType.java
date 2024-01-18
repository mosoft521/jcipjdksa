package generics2;

import java.util.ArrayList;

public class GenericType {
    public static void main(String[] args) {
        ArrayList<String> arrayString = new ArrayList<String>();
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
        System.out.println(arrayString.getClass() == arrayInteger.getClass());// true
    }
}