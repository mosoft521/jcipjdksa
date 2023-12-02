//package javaguide.java.newFeatures.java19;
//
//import jdk.jfr.MemoryAddress;
//
//import java.lang.foreign.Arena;
//import java.lang.foreign.FunctionDescriptor;
//import java.lang.foreign.Linker;
//import java.lang.foreign.MemorySegment;
//import java.lang.foreign.SegmentAllocator;
//import java.lang.foreign.SymbolLookup;
//import java.lang.foreign.ValueLayout;
//import java.lang.invoke.MethodHandle;
//import java.nio.file.Path;
//import java.util.Arrays;
//
///**
// * https://javaguide.cn/java/new-features/java19.html
// * https://openjdk.org/jeps/424
// * https://www.jdon.com/69138.html
// * //jdk20第二次增强
// * https://javaguide.cn/java/new-features/java20.html#jep-436-%E8%99%9A%E6%8B%9F%E7%BA%BF%E7%A8%8B-%E7%AC%AC%E4%BA%8C%E6%AC%A1%E9%A2%84%E8%A7%88
// * https://openjdk.org/jeps/434
// * //jdk21第三次预览
// * https://openjdk.org/jeps/442
// */
//public class FFMDemo {
//    public static void main(String[] args) throws Throwable {
//        // 1. 在C库路径上查找外部函数
//        Linker linker = Linker.nativeLinker();
//        SymbolLookup stdlib = linker.defaultLookup();
//        var fd = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT);
//        MethodHandle radixSort = linker.downcallHandle(stdlib.lookup("radixsort"), fd);
//        // 2. 分配堆上内存以存储四个字符串
//        String[] javaStrings   = { "mouse", "cat", "dog", "car" };
//        // 3. 分配堆外内存以存储四个指针
//        SegmentAllocator allocator = implicitAllocator();//todo:
//        MemorySegment offHeap  = allocator.allocateArray(ValueLayout.ADDRESS, javaStrings.length);
//        // 4. 将字符串从堆上复制到堆外
//        for (int i = 0; i < javaStrings.length; i++) {
//            // 在堆外分配一个字符串，然后存储指向它的指针
//            MemorySegment cString = allocator.allocateUtf8String(javaStrings[i]);
//            offHeap.setAtIndex(ValueLayout.ADDRESS, i, cString);
//        }
//        // 5. 通过调用外部函数对堆外数据进行排序
//        radixSort.invoke(offHeap, javaStrings.length, MemorySegment.NULL, '\0');
//        // 6. 将(重新排序的)字符串从堆外复制到堆上
//        for (int i = 0; i < javaStrings.length; i++) {
//            MemorySegment cStringPtr = offHeap.getAtIndex(ValueLayout.ADDRESS, i);
//            javaStrings[i] = cStringPtr.getUtf8String(0);
//        }
//        assert Arrays.equals(javaStrings, new String[] {"car", "cat", "dog", "mouse"});  // true
//    }
//}