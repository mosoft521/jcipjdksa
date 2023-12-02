package javaguide.java.newFeatures.java21;

import java.util.LinkedHashSet;
import java.util.List;

public class SequencedSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(1, 2, 3));

        Integer firstElement = linkedHashSet.getFirst();   // 1
        Integer lastElement = linkedHashSet.getLast();    // 3

        linkedHashSet.addFirst(0);  //List contains: [0, 1, 2, 3]
        linkedHashSet.addLast(4);   //List contains: [0, 1, 2, 3, 4]

        System.out.println(linkedHashSet.reversed());   //Prints [4, 3, 2, 1, 0]
    }
}