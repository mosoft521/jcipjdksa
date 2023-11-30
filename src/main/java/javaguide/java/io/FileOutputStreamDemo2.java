package javaguide.java.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
            byte[] array = "JavaGuide".getBytes();
            bos.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}