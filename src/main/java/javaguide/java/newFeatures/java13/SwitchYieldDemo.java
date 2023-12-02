package javaguide.java.newFeatures.java13;

public class SwitchYieldDemo {
    private static String descLanguage(String name) {
        return switch (name) {
            case "Java":
                yield "object-oriented, platform independent and secured";
            case "Ruby":
                yield "a programmer's best friend";
            default:
                yield name + " is a good language";
        };
    }

    public static void main(String[] args) {
        String name = "Java";
        System.out.println(descLanguage(name));
    }
}