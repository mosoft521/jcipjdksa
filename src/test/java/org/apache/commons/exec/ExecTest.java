package org.apache.commons.exec;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecTest {
    @Test
    public void execTest01() throws Exception {
        // 不使用工具类的写法
        Process process = Runtime.getRuntime().exec("cmd /c ping www.baidu.com");
        int exitCode = process.waitFor(); // 阻塞等待完成
        if (exitCode == 0) { // 状态码0表示执行成功
            String result = IOUtils.toString(process.getInputStream()); // "IOUtils" commons io中的工具类，详情可以参见前续文章介绍
            System.out.println(result);
        } else {
            String errMsg = IOUtils.toString(process.getErrorStream());
            System.out.println(errMsg);
        }
    }
    /*
���� Ping www.a.shifen.com [180.101.50.242] ���� 32 �ֽڵ�����:
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=11ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=22ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=10ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=19ms TTL=52

180.101.50.242 �� Ping ͳ����Ϣ:
    ���ݰ�: �ѷ��� = 4���ѽ��� = 4����ʧ = 0 (0% ��ʧ)��
�����г̵Ĺ���ʱ��(�Ժ���Ϊ��λ):
    ��� = 10ms��� = 22ms��ƽ�� = 15ms

进程已结束，退出代码为 0
     */

    @Test
    public void execTest02() throws IOException, InterruptedException {
        final Process process = Runtime.getRuntime().exec("cmd /c ping www.baidu.com");
        new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        process.exitValue();
                        break; // exitValue没有异常表示进程执行完成，退出循环
                    } catch (IllegalThreadStateException e) {
                        // 异常代表进程没有执行完
                    }
                    // 此处只做输出，对结果有其他需求可以在主线程使用其他容器收集此输出
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        process.waitFor();
    }
    /*
    ���� Ping www.a.shifen.com [180.101.50.242] ���� 32 �ֽڵ�����:
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=12ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=19ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=9ms TTL=52
���� 180.101.50.242 �Ļظ�: �ֽ�=32 ʱ��=13ms TTL=52

180.101.50.242 �� Ping ͳ����Ϣ:
    ���ݰ�: �ѷ��� = 4���ѽ��� = 4����ʧ = 0 (0% ��ʧ)��
�����г̵Ĺ���ʱ��(�Ժ���Ϊ��λ):
    ��� = 9ms��� = 19ms��ƽ�� = 13ms

进程已结束，退出代码为 0
     */

    @Test
    public void execTest03() throws IOException {
        String command = "ping www.baidu.com";
        // 接收正常结果流
        ByteArrayOutputStream susStream = new ByteArrayOutputStream();
        // 接收异常结果流
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        CommandLine commandLine = CommandLine.parse(command);
        DefaultExecutor exec = new DefaultExecutor();
        PumpStreamHandler streamHandler = new PumpStreamHandler(susStream, errStream);
        exec.setStreamHandler(streamHandler);
        int code = exec.execute(commandLine);
        System.out.println("result code: " + code);
        // 不同操作系统注意编码，否则结果乱码
        String suc = susStream.toString("GBK");
        String err = errStream.toString("GBK");
        System.out.println(suc);
        System.out.println(err);
    }
/*
result code: 0

正在 Ping www.a.shifen.com [180.101.50.242] 具有 32 字节的数据:
来自 180.101.50.242 的回复: 字节=32 时间=11ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=15ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=10ms TTL=52
来自 180.101.50.242 的回复: 字节=32 时间=10ms TTL=52

180.101.50.242 的 Ping 统计信息:
    数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
往返行程的估计时间(以毫秒为单位):
    最短 = 10ms，最长 = 15ms，平均 = 11ms

进程已结束，退出代码为 0
 */
}
