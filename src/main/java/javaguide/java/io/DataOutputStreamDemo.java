package javaguide.java.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
    public static void main(String[] args) {
        // 输出流
        try (FileOutputStream fileOutputStream = new FileOutputStream("output3.txt");
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            // 输出任意数据类型
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF("哈哈儿");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}