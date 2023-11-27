package javaguide.java.basic.ch09SyntacticSugar;
//java -jar c:\tools\cfr-0.152.jar LambdaTest3.class  --decodelambdas false

//import com.google.common.collect.ImmutableList;
//
//import java.lang.invoke.LambdaMetafactory;
//import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class LambdaTest4 {
//    public static void main(String... args) {
//        ImmutableList strList = ImmutableList.of((Object) "Hollis", (Object) "\u516c\u4f17\u53f7\uff1aHollis", (Object) "\u535a\u5ba2\uff1awww.hollischuang.com");
//        List<Object> HollisList = strList.stream().filter((Predicate<String>) LambdaMetafactory.metafactory(null, null, null, (Ljava / lang / Object;)Z, lambda$main$0(java.lang.String), (Ljava / lang / String;)Z)()).collect(Collectors.toList());
//        HollisList.forEach((Consumer<Object>) LambdaMetafactory.metafactory(null, null, null, (Ljava / lang / Object;)V, lambda$main$1(java.lang.Object), (Ljava / lang / Object;)V)());
//    }
//
//    private static /* synthetic */ void lambda$main$1(Object s) {
//        System.out.println(s);
//    }
//
//    private static /* synthetic */ boolean lambda$main$0(String string) {
//        return string.contains("Hollis");
//    }
//}