package javaguide.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("input3.txt");
             //必须将fileInputStream作为构造参数才能使用
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            //可以读取任意具体的类型数据
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
true
1
哈哈儿
 */