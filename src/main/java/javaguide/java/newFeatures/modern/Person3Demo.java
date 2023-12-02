package javaguide.java.newFeatures.modern;

public class Person3Demo {
    public static void main(String[] args) {
        Hint hint = Person3.class.getAnnotation(Hint.class);
        System.out.println(hint); // null
        Hints hints1 = Person3.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length); // 2

        Hint[] hints2 = Person3.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length); // 2
    }
}