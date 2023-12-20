package itbaima.nio.socket.nio.reactor2;

import itbaima.nio.socket.nio.reactor.Reactor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 创建Reactor对象，启动，完事
        try (Reactor reactor = new Reactor()) {
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}