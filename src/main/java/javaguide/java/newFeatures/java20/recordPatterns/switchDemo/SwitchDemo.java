package javaguide.java.newFeatures.java20.recordPatterns.switchDemo;

public class SwitchDemo {
    public static void main(String[] args) {
        Shape shape = new Circle(10);
        switch (shape) {

            case Circle(double radius):
                System.out.println("The shape is Circle with area: " + Math.PI * radius * radius);
                break;

            case Square(double side):
                System.out.println("The shape is Square with area: " + side * side);
                break;

            case Rectangle(double length, double width):
                System.out.println("The shape is Rectangle with area: + " + length * width);
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