package org.apache.commons.io;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MonitorTest {
    private static class myListener extends FileAlterationListenerAdaptor {
        @Override
        public void onFileCreate(File file) {
            System.out.println("fileCreated:" + file.getAbsolutePath());
        }

        @Override
        public void onFileChange(File file) {
            System.out.println("fileChanged:" + file.getAbsolutePath());
        }

        @Override
        public void onFileDelete(File file) {
            System.out.println("fileDeleted:" + file.getAbsolutePath());
        }
    }

    @Test
    public void monitorTest() throws Exception {
        // 监听目录下文件变化。可通过参数控制监听某些文件，默认监听目录所有文件
        FileAlterationObserver observer = new FileAlterationObserver("e:/foo");
        observer.addListener(new myListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor();
        monitor.addObserver(observer);
        monitor.start(); // 启动监视器
        Thread.currentThread().join(); // 避免主线程退出造成监视器退出
    }
}