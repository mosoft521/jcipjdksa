package javaguide.java.basic.javaBasicQuestions03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources01 {
    public static void main(String[] args) {
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D://read.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
/*
java.io.FileNotFoundException: D:\read.txt (系统找不到指定的文件。)
 */