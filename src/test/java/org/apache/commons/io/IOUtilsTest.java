package org.apache.commons.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class IOUtilsTest {
    @Test
    public void closeTest() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("test.txt");
        OutputStream outputStream = new FileOutputStream("test.txt");
        //使用后关闭
        // 原生写法
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void closeTest2() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("test.txt");
        OutputStream outputStream = new FileOutputStream("test.txt");
        //使用后关闭
        // commons写法(可以传任意数量的流)
        IOUtils.closeQuietly(inputStream, outputStream);
    }

    @Test
    public void read2ByteTest() throws IOException {
        // ==== 输入流转换为byte数组 ====
        // 原生写法
        InputStream is = new FileInputStream("foo.txt");
        byte[] buf = new byte[1024];
        int len;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((len = is.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        byte[] result = out.toByteArray();
        System.out.println(Arrays.toString(result));

        IOUtils.closeQuietly(is, out);
    }

    @Test
    public void read2ByteTest2() throws IOException {
        // ==== 输入流转换为byte数组 ====
        InputStream is = new FileInputStream("foo.txt");
        // commons写法
        byte[] result2 = IOUtils.toByteArray(is);
        System.out.println(Arrays.toString(result2));//[97, 98, 99, 49, 13, 10, 97, 98, 99, 50, 13, 10, 51, 51, 51, 13, 10]

        IOUtils.closeQuietly(is);
    }

    @Test
    public void read2StringTest() throws IOException {
        // ==== 输入流转换为字符串 ====
        // 原生写法
        InputStream is = new FileInputStream("foo.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        String result = sb.toString();
        System.out.println(result);

        IOUtils.closeQuietly(is);
    }

    @Test
    public void read2StringTest2() throws IOException {
        // ==== 输入流转换为字符串 ====
        InputStream is = new FileInputStream("foo.txt");
        // commons写法
        String result2 = IOUtils.toString(is, "UTF-8");
        System.out.println(result2);
        IOUtils.closeQuietly(is);
    }

    @Test
    public void otherTest() throws IOException {
        // 按照行读取结果
        InputStream is = new FileInputStream("test.txt");
        List<String> lines = IOUtils.readLines(is, "UTF-8");

        // 将行集合写入输出流
        OutputStream os = new FileOutputStream("newTest.txt");
        IOUtils.writeLines(lines, System.lineSeparator(), os, "UTF-8");

        // 拷贝输入流到输出流
        InputStream inputStream = new FileInputStream("src.txt");
        OutputStream outputStream = new FileOutputStream("dest.txt");
        IOUtils.copy(inputStream, outputStream);
    }
}