package javaguide.java.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamTest2 {
    @Test
    void copy_pdf_to_another_pdf_with_byte_array_buffer_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\计算机系统结构\\深入理解计算机操作系统.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\计算机系统结构\\深入理解计算机操作系统-副本.pdf"))) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    @Test
    void copy_pdf_to_another_pdf_with_byte_array_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("E:\\计算机系统结构\\深入理解计算机操作系统.pdf");
             FileOutputStream fos = new FileOutputStream("E:\\计算机系统结构\\深入理解计算机操作系统-副本2.pdf")) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }
}
/*
使用缓冲流复制PDF文件总耗时:2226 毫秒
使用普通流复制PDF文件总耗时:2741 毫秒
 */