package javaguide.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("inputR.txt"), "rw")) {
            randomAccessFile.write(new byte[]{'H', 'I', 'J', 'K'});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}