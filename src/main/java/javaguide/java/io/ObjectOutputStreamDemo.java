package javaguide.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.data"))) {
            MyClass myClass = new MyClass("Guide哥", "JavaGuide作者");
            output.writeObject(myClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}