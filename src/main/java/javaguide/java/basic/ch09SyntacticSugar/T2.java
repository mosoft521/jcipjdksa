package javaguide.java.basic.ch09SyntacticSugar;

/**
 * Classes cannot directly extend 'java.lang.Enum'
 */
//public final class T2 extends Enum {
//
//    public static T2[] values() {
//        return (T2[]) $VALUES.clone();
//    }
//
//    public static T2 valueOf(String name) {
//        return (T2) Enum.valueOf(T2.class, name);
//    }
//
//    private T2(String s, int i) {
//        super(s, i);
//    }
//
//    public static final T2 SPRING;
//    public static final T2 SUMMER;
//    private static final T2 $VALUES[];
//
//    static {
//        SPRING = new T2("SPRING", 0);
//        SUMMER = new T2("SUMMER", 1);
//        $VALUES = (new T2[]{
//                SPRING, SUMMER
//        });
//    }
//}