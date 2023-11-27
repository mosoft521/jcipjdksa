package javaguide.java.basic.ch09SyntacticSugar;

import com.google.common.collect.ImmutableList;

import java.util.Iterator;
import java.util.List;

public class ForEachTest2 {
    // 这里编译报错，为了通过编译，dummy一下
    //public static transient void main(String args[]) {
    public static void main(String args[]) {
        String strs[] = {
                "Hollis", "\u516C\u4F17\u53F7\uFF1AHollis", "\u535A\u5BA2\uFF1Awww.hollischuang.com"
        };
        String args1[] = strs;
        int i = args1.length;
        for (int j = 0; j < i; j++) {
            String s = args1[j];
            System.out.println(s);
        }

        List strList = ImmutableList.of("Hollis", "\u516C\u4F17\u53F7\uFF1AHollis", "\u535A\u5BA2\uFF1Awww.hollischuang.com");
        String s;
        for (Iterator iterator = strList.iterator(); iterator.hasNext(); System.out.println(s))
            s = (String) iterator.next();
    }
}