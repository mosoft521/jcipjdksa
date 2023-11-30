package javaguide.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorExample {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));

            Selector selector = Selector.open();
            // 将 ServerSocketChannel 注册到 Selector 并监听 OP_ACCEPT 事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int readyChannels = selector.select();

                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 处理连接事件
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        // 处理读事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = client.read(buffer);

                        if (bytesRead > 0) {
                            buffer.flip();
                            System.out.println("收到数据：" + new String(buffer.array(), 0, bytesRead));
                            // 将客户端通道注册到 Selector 并监听 OP_WRITE 事件
                            client.register(selector, SelectionKey.OP_WRITE);
                        } else if (bytesRead < 0) {
                            // 客户端断开连接
                            client.close();
                        }
                    } else if (key.isWritable()) {
                        // 处理写事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.wrap("Hello, Client!".getBytes());
                        client.write(buffer);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//用浏览器或者PostMan访问 http://localhost:8080，服务器打印如下log，但是浏览器或者PostMan报错
//    收到数据：GET / HTTP/1.1
//    Host: localhost:8080
//    Connection: keep-alive
//    Cache-Control: max-age=0
//    sec-ch-ua: "Google Chrome";v="119", "Chromium";v="119", "Not?A_Brand";v="24"
//    sec-ch-ua-mobile: ?0
//    sec-ch-ua-platform: "Windows"
//    Upgrade-Insecure-Requests: 1
//    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36
//    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
//Sec-Fetch-Site: cross-site
//Sec-Fetch-Mode: navigate
//Sec-Fetch-User: ?1
//Sec-Fetch-Dest: document
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9
//在Windows上安装Telnet【自行百度】
//cmd里
//telnet localhost 8080
//输入一些字符，如下图：
//退出telnet：ctrl+]
//quit