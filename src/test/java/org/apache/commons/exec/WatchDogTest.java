package org.apache.commons.exec;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class WatchDogTest {
    @Test
    public void watchDogTest01() {
        String command = "ping www.baidu.com";
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();
        // 设置一分钟超时
        ExecuteWatchdog watchdog = new ExecuteWatchdog(60_000);
        // 设置一秒钟超时
        // ExecuteWatchdog watchdog = new ExecuteWatchdog(1_000);
        exec.setWatchdog(watchdog);
        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        try {
            int code = exec.execute(commandLine);
            System.out.println(STR."result code: \{code}");
            // 不同操作系统注意编码，否则结果乱码
            String suc = susStream.toString("GBK");
            String err = errStream.toString("GBK");
            System.out.println(suc + err);
        } catch (ExecuteException e) {
            if (watchdog.killedProcess()) {
                // 被watchdog故意杀死
                System.err.println("超时了");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
设置一分钟超时
result code: 0

正在 Ping www.a.shifen.com [180.101.50.188] 具有 32 字节的数据:
来自 180.101.50.188 的回复: 字节=32 时间=10ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=9ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=14ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=9ms TTL=52

180.101.50.188 的 Ping 统计信息:
    数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
往返行程的估计时间(以毫秒为单位):
    最短 = 9ms，最长 = 14ms，平均 = 10ms

进程已结束，退出代码为 0

设置一秒钟超时

超时了

进程已结束，退出代码为 0
 */
}