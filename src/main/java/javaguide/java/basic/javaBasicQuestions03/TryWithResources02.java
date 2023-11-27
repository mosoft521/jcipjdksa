package javaguide.java.basic.javaBasicQuestions03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources02 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
/*
java.io.FileNotFoundException: test.txt (系统找不到指定的文件。)
 */