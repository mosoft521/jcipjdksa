//package javaguide.java.io;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class FileInputStreamDemo2 {
//    public static void main(String[] args) {
//        // 新建一个 BufferedInputStream 对象
//        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input2.txt"))) {
//            // 读取文件的内容并复制到 String 对象中
//            String result = new String(bufferedInputStream.readAllBytes());//need java 9
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}