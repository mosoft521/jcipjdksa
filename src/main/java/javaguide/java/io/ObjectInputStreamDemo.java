package javaguide.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.data"));
        MyClass myClass = (MyClass) input.readObject();
        System.out.println(myClass);
        input.close();
    }
}
/*
MyClass(name=Guide哥, desc=JavaGuide作者)
 */