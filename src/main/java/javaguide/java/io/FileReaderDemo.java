package javaguide.java.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("input.txt");) {
            int content;
            long skip = fileReader.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
The actual number of bytes skipped:2
The content read from file:JavaGuide
 */