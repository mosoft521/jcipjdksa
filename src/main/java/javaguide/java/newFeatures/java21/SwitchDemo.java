package javaguide.java.newFeatures.java21;

public class SwitchDemo {
    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }

    public static void main(String[] args) {
        System.out.println(formatterPatternSwitch("sss"));//String sss
        System.out.println(formatterPatternSwitch(123));//int 123
    }
}