package javaguide.java.newFeatures.java16;

public class InstanceDemo {
    public static void main(String[] args) {
        String o = "st";
        // Old code
        if (o instanceof String) {
            String s = (String) o;
            System.out.println(s);
        }

        // New code
        if (o instanceof String s) {
            System.out.println(s);
        }
    }
}