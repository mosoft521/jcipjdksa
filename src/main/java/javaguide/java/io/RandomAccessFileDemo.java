package javaguide.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("inputR.txt"), "rw")) {
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());
            // 指针当前偏移量为 6
            randomAccessFile.seek(6);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());
            // 从偏移量 7 的位置开始往后写入字节数据
            randomAccessFile.write(new byte[]{'H', 'I', 'J', 'K'});
            // 指针当前偏移量为 0，回到起始位置
            randomAccessFile.seek(0);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ",当前读取到的字符" + (char) randomAccessFile.read() + "，读取之后的偏移量：" + randomAccessFile.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
读取之前的偏移量：0,当前读取到的字符A，读取之后的偏移量：1
读取之前的偏移量：6,当前读取到的字符G，读取之后的偏移量：7
读取之前的偏移量：0,当前读取到的字符A，读取之后的偏移量：1
 */