package itbaima.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileTest {
    @Test
    public void test01() throws IOException {
    /*
      通过RandomAccessFile进行创建，注意后面的mode有几种：
      r        以只读的方式使用
      rw   读操作和写操作都可以
      rws  每当进行写操作，同步的刷新到磁盘，刷新内容和元数据
      rwd  每当进行写操作，同步的刷新到磁盘，刷新内容
     */
        try (RandomAccessFile f = new RandomAccessFile("test.txt", "")) {
        }
    }

    @Test
    public void test02() throws IOException {
        try (RandomAccessFile f = new RandomAccessFile("test.txt", "rw");  // 这里设定为支持读写，这样创建的通道才能具有这些功能
             FileChannel channel = f.getChannel()) {   // 通过RandomAccessFile创建一个通道
            channel.write(ByteBuffer.wrap("你好，世界！".getBytes()));

            System.out.println("写操作完成之后文件访问位置：" + channel.position());  // 注意读取也是从现在的位置开始 18
            channel.position(0);  // 需要将位置变回到最前面，这样下面才能从文件的最开始进行读取

            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);
            buffer.flip();

            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
        }
    }

    @Test
    public void test03() throws IOException {
        try (RandomAccessFile f = new RandomAccessFile("test.txt", "rw");
             FileChannel channel = f.getChannel()) {
            // 截断文件，只留前10个字节
            channel.truncate(10);

            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, buffer.remaining()));// 你好，�
        }
    }

    @Test
    public void testTransferTo() throws IOException {
        try (FileOutputStream out = new FileOutputStream("test2.txt");
             FileInputStream in = new FileInputStream("test.txt")) {

            FileChannel inChannel = in.getChannel();   // 获取到test文件的通道
            inChannel.transferTo(0, inChannel.size(), out.getChannel());   // 直接将test文件通道中的数据转到test2文件的通道中
        }
    }

    @Test
    public void testTransferFrom() throws IOException {
        try (FileOutputStream out = new FileOutputStream("test2.txt");
             FileInputStream in = new FileInputStream("test.txt")) {

            FileChannel inChannel = in.getChannel();   // 获取到test文件的通道
            out.getChannel().transferFrom(inChannel, 0, inChannel.size());   // 直接将从test文件通道中传来的数据转给test2文件的通道
        }
    }

    @Test
    public void testMappedByteBuffer() throws IOException {
        // 注意一定要是可写的，不然无法进行修改操作
        try (RandomAccessFile f = new RandomAccessFile("test.txt", "rw");
             FileChannel channel = f.getChannel()) {

            // 通过map方法映射文件的某一段内容，创建MappedByteBuffer对象
            // 比如这里就是从第四个字节开始，映射10字节内容到内存中
            // 注意这里需要使用MapMode.READ_WRITE模式，其他模式无法保存数据到文件
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 4, 10);

            // 我们可以直接对在内存中的数据进行编辑，也就是编辑Buffer中的内容
            // 注意这里写入也是从pos位置开始的，默认是从0开始，相对于文件就是从第四个字节开始写
            // 注意我们只映射了10个字节，也就是写的内容不能超出10字节了
            buffer.put("yyds".getBytes());//todo:这里有bug，时好时坏

            // 编辑完成后，通过force方法将数据写回文件的映射区域
            buffer.force();
        }
    }
}