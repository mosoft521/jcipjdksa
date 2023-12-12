package javaguide.java.basic.ch09SyntacticSugar;

/**
 * javap -c SwitchDemoString.class
 * jad SwitchDemoString.class
 */
public class SwitchDemoString2 {

    public SwitchDemoString2() {
    }

    public static void main(String[] args) {
        String str = "world";
        String s = str;
        byte byte0 = -1;
        switch (s.hashCode()) {
            case 99162322:
                if (s.equals("hello"))
                    byte0 = 0;
                break;

            case 113318802:
                if (s.equals("world"))
                    byte0 = 1;
                break;
        }
        switch (byte0) {
            case 0: // '\0'
                System.out.println("hello");
                break;

            case 1: // '\001'
                System.out.println("world");
                break;
        }
    }
}
/*
world
 */