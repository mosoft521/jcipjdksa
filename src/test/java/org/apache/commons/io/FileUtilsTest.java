package org.apache.commons.io;

import org.apache.commons.io.file.Counters;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class FileUtilsTest {
    @Test
    public void readAndWriteTest() throws IOException {
        File readFile = new File("test.txt");
        // 读取文件
        String str = FileUtils.readFileToString(readFile, "UTF-8");
        // 读取文件为字节数组
        byte[] bytes = FileUtils.readFileToByteArray(readFile);
        // 按行读取文件
        List<String> lines = FileUtils.readLines(readFile, "UTF-8");

        File writeFile = new File("out.txt");
        // 将字符串写入文件
        FileUtils.writeStringToFile(writeFile, "测试文本", "UTF-8");
        // 将字节数组写入文件
        FileUtils.writeByteArrayToFile(writeFile, bytes);
        // 将字符串列表一行一行写入文件
        FileUtils.writeLines(writeFile, "UTF-8", lines);
    }

    @Test
    public void moveAndCopyTest() throws IOException {
        File srcFile = new File("src.txt");
        File destFile = new File("dest-" + RandomStringUtils.randomNumeric(5) + ".txt");
        File srcDir = new File("srcDir");
        File destDir = new File("destDir");
        // 移动/拷贝文件
        FileUtils.moveFile(srcFile, destFile);
        FileUtils.copyFile(srcFile, destFile);
        // 移动/拷贝文件到目录
        FileUtils.moveFileToDirectory(srcFile, destDir, true);
        FileUtils.copyFileToDirectory(srcFile, destDir, true);
        // 移动/拷贝目录
        FileUtils.moveDirectory(srcDir, destDir);
        FileUtils.copyDirectory(srcDir, destDir);
        // 拷贝网络资源到文件
        FileUtils.copyURLToFile(new URL("http://www.baidu.com"), destFile);
        // 拷贝流到文件
        FileUtils.copyInputStreamToFile(new FileInputStream("test.txt"), destFile);
        // ... ...
    }

    @Test
    public void otherTest() throws IOException {
        File file = new File("test.txt");
        File dir = new File("/test");
        // 删除文件
        // FileUtils.delete(file);
        // 删除目录
        // FileUtils.deleteDirectory(dir);
        // 文件大小，如果是目录则递归计算总大小
        long s = FileUtils.sizeOf(file);
        System.out.println(s);
        // 则递归计算目录总大小，参数不是目录会抛出异常
        long sd = FileUtils.sizeOfDirectory(dir);
        System.out.println(sd);
        // 递归获取目录下的所有文件
        Collection<File> files = FileUtils.listFiles(dir, null, true);
        for (File f : files) {
            System.out.println(f.getName());
            System.out.println(f.getCanonicalPath());
        }
        System.out.println("###");
        // 递归获取目录下的所有子目录及文件
        Collection<File> files2 = FileUtils.listFilesAndDirs(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File f : files2) {
            System.out.println(f.getName());
            System.out.println(f.getCanonicalPath());
        }
        System.out.println("#####");
        // 获取jvm中的io临时目录
        File tempDirectory = FileUtils.getTempDirectory();
        System.out.println(tempDirectory.getName());
        System.out.println(tempDirectory.getCanonicalPath());
        // ... ...
    }

    @Test
    public void fileNameTest() {
        // 获取名称，后缀等
        String name = "/home/xxx/test.txt";
        System.out.println(FilenameUtils.getName(name)); // "test.txt"
        System.out.println(FilenameUtils.getBaseName(name)); // "test"
        System.out.println(FilenameUtils.getExtension(name)); // "txt"
        System.out.println(FilenameUtils.getPath(name)); // "/home/xxx/"

        // 将相对路径转换为绝对路径
        System.out.println(FilenameUtils.normalize("d:/foo/bar/..")); // "d:\foo\"
    }

    @Test
    public void jdk7PathTest() throws IOException {
        // path既可以表示目录也可以表示文件

        // 获取当前路径
        Path path = PathUtils.current();
        System.out.println(path.getFileName());
        // 删除path
        // PathUtils.delete(path);
        // 路径或文件是否为空
        System.out.println(PathUtils.isEmpty(path));
        // 设置只读
        // PathUtils.setReadOnly(path, true);
        // 复制
        PathUtils.copyFileToDirectory(Paths.get("test.txt"), path);
        PathUtils.copyDirectory(Paths.get("srcPath"), Paths.get("destPath"));
        // 统计目录内文件数量
        Counters.PathCounters counters = PathUtils.countDirectory(path);
        System.out.println(counters.getByteCounter()); // 字节大小
        System.out.println(counters.getDirectoryCounter()); // 目录个数
        System.out.println(counters.getFileCounter()); // 文件个数
        // ... ...
    }
}