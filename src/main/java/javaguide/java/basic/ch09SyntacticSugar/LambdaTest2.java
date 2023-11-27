package javaguide.java.basic.ch09SyntacticSugar;
//java -jar c:\tools\cfr-0.152.jar LambdaTest.class --decodelambdas false

//import com.google.common.collect.ImmutableList;
//import java.lang.invoke.LambdaMetafactory;
//import java.util.function.Consumer;
//
//public class LambdaTest2 {
//    public static void main(String[] args) {
//        ImmutableList strList = ImmutableList.of((Object)"Hollis", (Object)"\u516c\u4f17\u53f7\uff1aHollis", (Object)"\u535a\u5ba2\uff1awww.hollischuang.com");
//        strList.forEach((Consumer<String>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, lambda$main$0(java.lang.String ), (Ljava/lang/String;)V)());
//    }
//
//    private static /* synthetic */ void lambda$main$0(String s) {
//        System.out.println(s);
//    }
//}