package javaguide.java.newFeatures.java14;

public class RectangleDemo {
    public static void main(String[] args) {
        RectangleRecord rectangleRecord = new RectangleRecord(1, 2);
        System.out.println(rectangleRecord.length());//1.0
        System.out.println(rectangleRecord.width());//2.0
    }
}