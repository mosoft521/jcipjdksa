package javaguide.java.jvm;

public class PrintClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = PrintClassLoaderTree.class.getClassLoader();
        StringBuilder split = new StringBuilder("|--");
        boolean needContinue = true;
        while (needContinue) {
            System.out.println(split.toString() + classLoader);
            if (classLoader == null) {
                needContinue = false;
            } else {
                classLoader = classLoader.getParent();
                split.insert(0, "\t");
            }
        }
    }
}
/*
|--sun.misc.Launcher$AppClassLoader@18b4aac2
	|--sun.misc.Launcher$ExtClassLoader@49476842
		|--null

Process finished with exit code 0
 */