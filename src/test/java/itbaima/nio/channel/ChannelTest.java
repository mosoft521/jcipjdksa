package itbaima.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * 解决：IDEA 使用junit测试中new Scanner(System.in)没办法输入问题
 * help ->Edit Custom VM Options… -> 加上 -Deditable.java.test.console=true
 */
public class ChannelTest {
    @Test
    public void testBio() throws IOException {
        // 数组创建好，一会用来存放从流中读取到的数据
        byte[] data = new byte[10];
        // 直接使用输入流
        InputStream in = System.in;
        while (true) {
            int len;
            while ((len = in.read(data)) >= 0) {  // 将输入流中的数据一次性读取到数组中
                System.out.print("读取到一批数据：" + new String(data, 0, len));  // 读取了多少打印多少
            }
        }
    }

    @Test
    public void testNio() throws IOException {
        // 缓冲区创建好，一会就靠它来传输数据
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 将System.in作为输入源，一会Channel就可以从这里读取数据，然后通过缓冲区装载一次性传递数据
        ReadableByteChannel readChannel = Channels.newChannel(System.in);
        while (true) {
            // 将通道中的数据写到缓冲区中，缓冲区最多一次装10个
            readChannel.read(buffer);
            // 写入操作结束之后，需要进行翻转，以便接下来的读取操作
            buffer.flip();
            // 最后转换成String打印出来康康
            System.out.println("读取到一批数据：" + new String(buffer.array(), 0, buffer.remaining()));
            // 回到最开始的状态
            buffer.clear();
        }
    }

    @Test
    public void testTraditionalFileIO() throws IOException {
        try (FileOutputStream out = new FileOutputStream("test.txt");
             FileInputStream in = new FileInputStream("test.txt")) {
            String data = "你好，世界！";
            out.write(data.getBytes());   // 向文件的输出流中写入数据，也就是把数据写到文件中
            out.flush();

            byte[] bytes = new byte[in.available()];
            in.read(bytes);    // 从文件的输入流中读取文件的信息
            System.out.println(new String(bytes));// 你好，世界！
        }
    }

    @Test
    public void testFileInputStreamChannelRead() throws IOException {
        // 1. 直接通过输入或输出流获取对应的通道
        FileInputStream in = new FileInputStream("test.txt");
        // 但是这里的通道只支持读取或是写入操作
        FileChannel channel = in.getChannel();
        // 创建一个容量为128的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(128);
        // 从通道中将数据读取到缓冲区中
        channel.read(buffer);
        // 翻转一下，接下来要读取了
        buffer.flip();

        System.out.println(new String(buffer.array(), 0, buffer.remaining()));// 你好，世界！
    }

    @Test
    public void testFileInputStreamChannelWrite() throws IOException {
        // 1. 直接通过输入或输出流获取对应的通道
        FileInputStream in = new FileInputStream("test2.txt");
        // 但是这里的通道只支持读取或是写入操作
        FileChannel channel = in.getChannel();
        // 尝试写入一下
        channel.write(ByteBuffer.wrap("你好，世界！".getBytes()));// java.nio.channels.NonWritableChannelException
    }

    @Test
    public void testFileOutputStreamChannelWrite() throws IOException {
        // 1. 直接通过输入或输出流获取对应的通道
        FileOutputStream out = new FileOutputStream("test2.txt");
        // 但是这里的通道只支持读取或是写入操作
        FileChannel channel = out.getChannel();
        // 尝试写入一下
        channel.write(ByteBuffer.wrap("你好，世界！".getBytes()));
    }

    @Test
    public void testFileOutputStreamChannelRead() throws IOException {
        // 1. 直接通过输入或输出流获取对应的通道
        FileOutputStream out = new FileOutputStream("test.txt");
        // 但是这里的通道只支持读取或是写入操作
        FileChannel channel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        // 从通道中将数据读取到缓冲区中
        channel.read(buffer);
        // 翻转一下，接下来要读取了
        buffer.flip();

        System.out.println(new String(buffer.array(), 0, buffer.remaining()));// java.nio.channels.NonReadableChannelException
    }
}