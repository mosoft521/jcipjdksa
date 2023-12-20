package itbaima.nio.buffer;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class BufferTest {
    @Test
    public void testCreate() {
        // 创建一个缓冲区不能直接new，而是需要使用静态方法去生成，有两种方式：
        // 1. 申请一个容量为10的int缓冲区
        IntBuffer buffer = IntBuffer.allocate(10);
        // 2. 可以将现有的数组直接转换为缓冲区（包括数组中的数据）
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntBuffer buffer2 = IntBuffer.wrap(arr);
    }

    @Test
    public void testPut1() {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(1).put(2).put(3);   // 我们依次存放三个数据试试看
        System.out.println(buffer);// java.nio.HeapIntBuffer[pos=3 lim=10 cap=10]
    }

    @Test
    public void testPut2() {
        IntBuffer buffer = IntBuffer.allocate(10);
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        buffer.put(arr, 3, 4);  // 从下标3开始，截取4个元素

        System.out.println(Arrays.toString(buffer.array()));  // array方法可以直接获取到数组 [4, 5, 6, 7, 0, 0, 0, 0, 0, 0]
    }

    @Test
    public void testPut3() {
        IntBuffer src = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(src);
        System.out.println(Arrays.toString(buffer.array()));  //  [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
    }

    @Test
    public void testPut4() {
        IntBuffer src = IntBuffer.allocate(5);
        for (int i = 0; i < 5; i++) src.put(i);   // 手动插入数据
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(src);
        System.out.println(Arrays.toString(buffer.array()));//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    }

    @Test
    public void testPut5() {
        IntBuffer src = IntBuffer.allocate(5);
        for (int i = 0; i < 5; i++) src.put(i);
        IntBuffer buffer = IntBuffer.allocate(10);

        src.flip();   // 我们可以通过flip来翻转缓冲区
        buffer.put(src);
        System.out.println(Arrays.toString(buffer.array()));//[0, 1, 2, 3, 4, 0, 0, 0, 0, 0]
    }

    @Test
    public void testGet1() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        int[] arr = new int[10];
        buffer.get(arr, 2, 5);
        System.out.println(Arrays.toString(arr));//[0, 0, 1, 2, 3, 4, 5, 0, 0, 0]
    }

    @Test
    public void testArray() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(buffer.array()));//[1, 2, 3, 4, 5]
    }

    @Test
    public void testArray2() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        int[] arr = buffer.array();
        arr[0] = 99999;   // 拿到数组对象直接改
        System.out.println(buffer.get());// 99999
    }

    @Test
    public void testMark() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{0, 1, 2, 3, 4});
        buffer.get();   // 读取一位，那么position就变成1了
        buffer.mark();   // 这时标记，那么mark = 1
        buffer.get();   // 又读取一位，那么position就变成2了
        buffer.reset();    // 直接将position = mark，也就是变回1
        System.out.println(buffer.get());// 1
    }

    @Test
    public void testCompact() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        for (int i = 0; i < 4; i++) buffer.get();   // 先正常读4个
        buffer.compact();   // 压缩缓冲区

        System.out.println("压缩之后的情况：" + Arrays.toString(buffer.array()));//[5, 6, 7, 8, 9, 0, 7, 8, 9, 0]
        System.out.println("当前position位置：" + buffer.position());// 6
        System.out.println("当前limit位置：" + buffer.limit());// 10
    }

    @Test
    public void testDuplicate() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        IntBuffer duplicate = buffer.duplicate();

        System.out.println(buffer == duplicate);// false
        System.out.println(buffer.array() == duplicate.array());// true
    }

    @Test
    public void testDuplicate2() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        IntBuffer duplicate = buffer.duplicate();

        buffer.put(0, 66666);
        System.out.println(duplicate.get());// 66666
    }

    @Test
    public void testSlice() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        for (int i = 0; i < 4; i++) buffer.get();
        IntBuffer slice = buffer.slice();

        System.out.println("划分之后的情况：" + Arrays.toString(slice.array()));//[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        System.out.println("划分之后的偏移地址：" + slice.arrayOffset());// 4
        System.out.println("当前position位置：" + slice.position());// 0
        System.out.println("当前limit位置：" + slice.limit());// 6

        while (slice.hasRemaining()) {   // 将所有的数据全部挨着打印出来
            System.out.print(slice.get() + ", ");// 5, 6, 7, 8, 9, 0,
        }
    }

    @Test
    public void testEquals() {
        IntBuffer buffer1 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        IntBuffer buffer2 = IntBuffer.wrap(new int[]{6, 5, 4, 3, 2, 1, 7, 8, 9, 0});
        System.out.println(buffer1.equals(buffer2));   // 直接比较 false

        buffer1.position(6);
        buffer2.position(6);
        System.out.println(buffer1.equals(buffer2));   // 比较从下标6开始的剩余内容 true
    }

    @Test
    public void testReadOnly() {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        IntBuffer readBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readBuffer.isReadOnly());// true
        System.out.println(readBuffer.get());// 1
        readBuffer.put(0, 666);// java.nio.ReadOnlyBufferException
    }

    @Test
    public void testByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 除了直接丢byte进去之外，我们也可以丢其他的基本类型（注意容量消耗）
        buffer.putInt(Integer.MAX_VALUE);  // 丢个int的最大值进去，注意一个int占4字节
        System.out.println("当前缓冲区剩余字节数：" + buffer.remaining());  // 当前缓冲区剩余字节数：6

        // 我们来尝试读取一下，记得先翻转
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());   // 一共四个字节 127 -1 -1 -1
        }
    }

    @Test
    public void testByteBuffer2() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        buffer.put((byte) 1);
        buffer.put((byte) -1);

        buffer.flip();   // 翻转一下
        System.out.println(buffer.getInt());  // 以int形式获取，那么就是一次性获取4个字节 511
    }

    @Test
    public void testCharBuffer() {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put("abcde");  // 除了可以直接丢char之外，字符串也可以一次性丢进入
        System.out.println(Arrays.toString(buffer.array()));//[a, b, c, d, e,  ,  ,  ,  ,  ]
    }

    @Test
    public void testCharBuffer2() {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put("12345");
        buffer.append("!");   // 可以像StringBuilder一样使用append来继续添加数据

        System.out.println("剩余容量：" + buffer.remaining());  // 剩余容量：4

        buffer.flip();
        System.out.println("整个字符串为：" + buffer);   // 整个字符串为：12345!
        System.out.println("第3个字符是：" + buffer.charAt(2));  // 第3个字符是：3

        buffer   // 也可以转换为IntStream进行操作
                .chars()
                .filter(i -> i < '3')
                .forEach(i -> System.out.print((char) i));// 12!
    }

    @Test
    public void testCharBuffer3() {
        // 可以直接使用wrap包装一个字符串，但是注意，包装出来之后是只读的
        CharBuffer buffer = CharBuffer.wrap("收藏等于学会~");
        System.out.println(buffer);
        buffer.put("111");  // 这里尝试进行一下写操作 java.nio.ReadOnlyBufferException
    }

    @Test
    public void testDirect() {
        // 这里我们申请一个直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        // 使用方式基本和之前是一样的
        buffer.put((byte) 66);
        buffer.flip();
        System.out.println(buffer.get());// 66
    }
}