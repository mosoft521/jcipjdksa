package org.apache.commons.exec;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.function.Consumer;

public class ExecAsyncTest {
    private static class ProcessResult {
        public boolean success;
        public String result;
    }

    private static void execAsync(String command, Consumer<ProcessResult> callback) throws IOException {
        final Process process = Runtime.getRuntime().exec(command);
        new Thread(() -> {
            StringBuilder successMsg = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"))) {
                // 存放临时结果
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        successMsg.append(line).append("\r\n");
                        int exitCode = process.exitValue();
                        ProcessResult pr = new ProcessResult();
                        if (exitCode == 0) {
                            pr.success = true;
                            pr.result = successMsg.toString();
                        } else {
                            pr.success = false;
                            pr.result = IOUtils.toString(process.getErrorStream());
                        }
                        callback.accept(pr); // 回调主线程注册的函数
                        break; // exitValue没有异常表示进程执行完成，退出循环
                    } catch (IllegalThreadStateException e) {
                        // 异常代表进程没有执行完
                    }
                    try {
                        // 等待100毫秒在检查是否完成
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Test
    public void execAsyncTest01() throws IOException, InterruptedException {
        System.out.println("1. 开始执行");
        String cmd = "cmd /c ping www.baidu.com"; // 假设是一个耗时的操作
        execAsync(cmd, processResult -> {
            System.out.println("3. 异步执行完成，success=" + processResult.success + "; msg=" + processResult.result);
            System.exit(0);
        });
        // 做其他操作 ... ...
        System.out.println("2. 做其他操作");
        // 避免主线程退出导致程序退出
        Thread.currentThread().join();
    }
/*
1. 开始执行
2. 做其他操作
3. 异步执行完成，success=true; msg=
正在 Ping www.a.shifen.com [180.101.50.188] 具有 32 字节的数据:
来自 180.101.50.188 的回复: 字节=32 时间=11ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=14ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=14ms TTL=52
来自 180.101.50.188 的回复: 字节=32 时间=8ms TTL=52

进程已结束，退出代码为 0
 */

    @Test
    public void execAsyncTest02() throws IOException, InterruptedException {
        String command = "ping www.baidu.com";
        // 接收正常结果流
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        // 接收异常结果流
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();

        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        ExecuteResultHandler erh = new ExecuteResultHandler() {
            @Override
            public void onProcessComplete(int exitValue) {
                try {
                    String suc = susStream.toString("GBK");
                    System.out.println(suc);
                    System.out.println("3. 异步执行完成");
                } catch (UnsupportedEncodingException uee) {
                    uee.printStackTrace();
                }
            }

            @Override
            public void onProcessFailed(ExecuteException e) {
                try {
                    String err = errStream.toString("GBK");
                    System.out.println(err);
                    System.out.println("3. 异步执行出错");
                } catch (UnsupportedEncodingException uee) {
                    uee.printStackTrace();
                }
            }
        };
        System.out.println("1. 开始执行");
        exec.execute(commandLine, erh);
        System.out.println("2. 做其他操作");
        // 避免主线程退出导致程序退出
        Thread.currentThread().join();
    }
/*
1. 开始执行
2. 做其他操作

正在 Ping www.a.shifen.com [180.101.50.242] 具有 32 字节的数据:
来自 180.101.50.242 的回复: 字节=32 时间=18ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=17ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=10ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=9ms TTL=52

180.101.50.242 的 Ping 统计信息:
    数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
往返行程的估计时间(以毫秒为单位):
    最短 = 9ms，最长 = 18ms，平均 = 13ms

3. 异步执行完成
todo: 未结束
 */
}
