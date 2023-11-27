package javaguide.java.basic.javaBasicQuestions01;

public class VariableLengthArgument {

    public static void printVariable(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void printVariable(String arg1, String arg2) {
        System.out.println(arg1 + arg2);
    }

    public static void main(String[] args) {
        printVariable("a", "b");
        printVariable("a", "b", "c", "d");
    }
}
/*
ab
a
b
c
d
#javap -c javaguide.java.basic.javaBasicQuestions01.VariableLengthArgument
Compiled from "VariableLengthArgument.java"
public class javaguide.java.basic.javaBasicQuestions01.VariableLengthArgument {
  public javaguide.java.basic.javaBasicQuestions01.VariableLengthArgument();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void printVariable(java.lang.String...);
    Code:
       0: aload_0
       1: astore_1
       2: aload_1
       3: arraylength
       4: istore_2
       5: iconst_0
       6: istore_3
       7: iload_3
       8: iload_2
       9: if_icmpge     31
      12: aload_1
      13: iload_3
      14: aaload
      15: astore        4
      17: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
      20: aload         4
      22: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      25: iinc          3, 1
      28: goto          7
      31: return

  public static void printVariable(java.lang.String, java.lang.String);
    Code:
       0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #19                 // class java/lang/StringBuilder
       6: dup
       7: invokespecial #21                 // Method java/lang/StringBuilder."<init>":()V
      10: aload_0
      11: invokevirtual #22                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      14: aload_1
      15: invokevirtual #22                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      18: invokevirtual #26                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      21: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      24: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #30                 // String a
       2: ldc           #32                 // String b
       4: invokestatic  #34                 // Method printVariable:(Ljava/lang/String;Ljava/lang/String;)V
       7: iconst_4
       8: anewarray     #40                 // class java/lang/String
      11: dup
      12: iconst_0
      13: ldc           #30                 // String a
      15: aastore
      16: dup
      17: iconst_1
      18: ldc           #32                 // String b
      20: aastore
      21: dup
      22: iconst_2
      23: ldc           #42                 // String c
      25: aastore
      26: dup
      27: iconst_3
      28: ldc           #44                 // String d
      30: aastore
      31: invokestatic  #46                 // Method printVariable:([Ljava/lang/String;)V
      34: return
}
#jad VariableLengthArgument.class
Parsing VariableLengthArgument.class...Overwrite VariableLengthArgument.jad [y/n/a/s] ? y
 Generating VariableLengthArgument.jad

    public static transient void printVariable(String args[])
    {
        String as[] = args;
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s = as[j];
            System.out.println(s);
        }

    }
 */