package javaguide.java.newFeatures.java20.recordPatterns.instanceDemo;

public class ShapeDemoOld {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle", 10);
        if (circle instanceof Shape shape) {
            System.out.println("Area of " + shape.type() + " is : " + Math.PI * Math.pow(shape.unit(), 2)); // Area of Circle is : 314.1592653589793
        }
    }
}