package itbaima.nio.socket.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class BioChannelClient {
    public static void main(String[] args) {
        // 创建一个新的SocketChannel，一会通过通道进行通信
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("已连接到服务端！");
            System.out.println("请输入要发送给服务端的内容：");
            String text = scanner.nextLine();
            // 直接向通道中写入数据，真舒服
            channel.write(ByteBuffer.wrap(text.getBytes()));

            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);   // 直接从通道中读取数据
            buffer.flip();
            System.out.println("收到服务器返回：" + new String(buffer.array(), 0, buffer.remaining()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}