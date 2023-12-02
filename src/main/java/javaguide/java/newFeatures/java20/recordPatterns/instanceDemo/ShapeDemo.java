package javaguide.java.newFeatures.java20.recordPatterns.instanceDemo;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle", 10);
        if (circle instanceof Shape(String type, long unit)) {
            System.out.println("Area of " + type + " is : " + Math.PI * Math.pow(unit, 2)); // Area of Circle is : 314.1592653589793
        }
    }
}