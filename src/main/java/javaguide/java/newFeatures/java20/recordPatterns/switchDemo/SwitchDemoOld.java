package javaguide.java.newFeatures.java20.recordPatterns.switchDemo;

public class SwitchDemoOld {
    public static void main(String[] args) {
        Shape shape = new Circle(10);
        switch (shape) {
            case Circle c:
                System.out.println("The shape is Circle with area: " + Math.PI * c.radius() * c.radius());
                break;

            case Square s:
                System.out.println("The shape is Square with area: " + s.side() * s.side());
                break;

            case Rectangle r:
                System.out.println("The shape is Rectangle with area: + " + r.length() * r.width());
                break;

            default:
                System.out.println("Unknown Shape");
                break;
        }
    }
}
/*
The shape is Circle with area: 314.1592653589793
 */