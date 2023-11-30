package javaguide.java.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) {
        try (Writer output = new FileWriter("output4.txt")) {
            output.write("你好，我是Guide。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}