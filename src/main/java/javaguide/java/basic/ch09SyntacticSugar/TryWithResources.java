package javaguide.java.basic.ch09SyntacticSugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("d:\\hollischuang.xml"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                // handle exception
            }
        }
    }
}