package javaguide.java.basic.ch09SyntacticSugar;

public class VariableArguments2 {
    public static void main(String args[]) {
        print(new String[]{
                "Holis", "\u516C\u4F17\u53F7:Hollis", "\u535A\u5BA2\uFF1Awww.hollischuang.com", "QQ\uFF1A907607222"
        });
    }

    //public static transient void print(String strs[]) {//in jvm
    public static void print(String strs[]) {
        for (int i = 0; i < strs.length; i++)
            System.out.println(strs[i]);

    }
}