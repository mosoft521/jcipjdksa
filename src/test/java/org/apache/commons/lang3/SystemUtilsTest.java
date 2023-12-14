package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

import java.io.File;

public class SystemUtilsTest {
    @Test
    public void systemUtilsTest() {
        // 判断操作系统类型
        boolean isWin = SystemUtils.IS_OS_WINDOWS;
        System.out.println(isWin);//true
        boolean isWin10 = SystemUtils.IS_OS_WINDOWS_10;
        System.out.println(isWin10);//true
        boolean isWin2012 = SystemUtils.IS_OS_WINDOWS_2012;
        System.out.println(isWin2012);//false
        boolean isMac = SystemUtils.IS_OS_MAC;
        System.out.println(isMac);//false
        boolean isLinux = SystemUtils.IS_OS_LINUX;
        System.out.println(isLinux);//false
        boolean isUnix = SystemUtils.IS_OS_UNIX;
        System.out.println(isUnix);//false
        boolean isSolaris = SystemUtils.IS_OS_SOLARIS;
        System.out.println(isSolaris);//false
        // ... ...

        // 判断java版本
        boolean isJava6 = SystemUtils.IS_JAVA_1_6;
        System.out.println(isJava6);//false
        boolean isJava8 = SystemUtils.IS_JAVA_1_8;
        System.out.println(isJava8);//false
        boolean isJava11 = SystemUtils.IS_JAVA_11;
        System.out.println(isJava11);//false
        boolean isJava17 = SystemUtils.IS_JAVA_17;
        System.out.println(isJava17);//false
        boolean isJava21 = SystemUtils.IS_JAVA_21;
        System.out.println(isJava21);//true
        // ... ...

        // 获取java相关目录
        File javaHome = SystemUtils.getJavaHome();
        System.out.println(javaHome.toString());//C:\tools\Java\jdk-21
        File userHome = SystemUtils.getUserHome();// 操作系统用户目录
        System.out.println(userHome.toString());//C:\Users\Alvin
        File userDir = SystemUtils.getUserDir();// 项目所在路径
        System.out.println(userDir.toString());//E:\ws-ij-alvin-git-tmp\jcipjdksa-alvin
        File tmpDir = SystemUtils.getJavaIoTmpDir();
        System.out.println(tmpDir.toString());//C:\Users\Alvin\AppData\Local\Temp
    }
}