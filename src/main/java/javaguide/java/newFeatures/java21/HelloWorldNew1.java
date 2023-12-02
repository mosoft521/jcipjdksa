package javaguide.java.newFeatures.java21;

/**
 * https://openjdk.org/jeps/445
 */
public class HelloWorldNew1 {
    void main() {
        System.out.println("Hello, World!");
    }
}
/*
cd E:\ws-ij-alvin-git-tmp\jcipjdksa-alvin\src\main\java\javaguide\java\newFeatures\java21
javac --release 21 --enable-preview HelloWorldNew1.java
cd E:\ws-ij-alvin-git-tmp\jcipjdksa-alvin\src\main\java
java --enable-preview javaguide.java.newFeatures.java21.HelloWorldNew1
输出：Hello, World!
 */