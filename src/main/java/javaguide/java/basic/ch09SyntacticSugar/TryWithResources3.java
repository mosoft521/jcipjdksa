package javaguide.java.basic.ch09SyntacticSugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//public class TryWithResources3 {
//    public static transient void main(String args[]) {
//        BufferedReader br;
//        Throwable throwable;
//        br = new BufferedReader(new FileReader("d:\\ hollischuang.xml"));
//        throwable = null;
//        String line;
//        try {
//            while ((line = br.readLine()) != null)
//                System.out.println(line);
//        } catch (Throwable throwable2) {
//            throwable = throwable2;
//            throw throwable2;
//        }
//        if (br != null)
//            if (throwable != null)
//                try {
//                    br.close();
//                } catch (Throwable throwable1) {
//                    throwable.addSuppressed(throwable1);
//                }
//            else
//                br.close();
//        break MISSING_BLOCK_LABEL_113;
//        Exception exception;
//        exception;
//        if (br != null)
//            if (throwable != null)
//                try {
//                    br.close();
//                } catch (Throwable throwable3) {
//                    throwable.addSuppressed(throwable3);
//                }
//            else
//                br.close();
//        throw exception;
//        IOException ioexception;
//        ioexception;
//    }
//}