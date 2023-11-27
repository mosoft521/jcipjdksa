package javaguide.java.basic.ch09SyntacticSugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources2 {
    public static void main(String... args) {
        try (BufferedReader br = new BufferedReader(new FileReader("d:\\ hollischuang.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception
        }
    }
}