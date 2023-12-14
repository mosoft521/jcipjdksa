package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringTest {
    @Test
    public void isEmptyTest() {
        String str = null;
        // 原生写法
        if (str == null || str.isEmpty()) {
            System.out.println("str is null or empty");
        }
        // commons写法
        if (StringUtils.isEmpty(str)) {
            System.out.println("str is null or empty");
        }
    }

    @Test
    public void isEmpty2Test() {
        String str = null;
        String str1 = "s1";
        String str2 = "";
        String str3 = "s3";
        // isEmpty取反
        boolean notEmpty = StringUtils.isNotEmpty(str);
        System.out.println(notEmpty);//false

        boolean blank = StringUtils.isBlank(str);
        System.out.println(blank);//true
        // isBlank取反
        boolean notBlank = StringUtils.isNotBlank(str);
        System.out.println(notBlank);//false
        // 任意一个参数为空则结果为true
        boolean anyEmpty = StringUtils.isAnyEmpty(str1, str2, str3);
        System.out.println(anyEmpty);//true
        // 所有参数为空则结果为true
        boolean allEmpty = StringUtils.isAllEmpty(str1, str2, str3);
        System.out.println(allEmpty);//false
    }

    @Test
    public void trimTest() {
        String str = " abc  ";
        String str2 = "";
        // 去除两端空格，不需要判断null
        String newStr = StringUtils.trim(str);
        System.out.println(newStr);//"abc"
        newStr = StringUtils.trimToEmpty(str2);
        System.out.println(newStr);//""
        newStr = StringUtils.trimToNull(str2);
        System.out.println(newStr);//null

        // 去两端 给定字符串中任意字符
        newStr = StringUtils.strip("  abcyx", "xyz");
        System.out.println(newStr);//"  abc"
        newStr = StringUtils.strip(" abc ", null);
        System.out.println(newStr);//"abc"
        // 去左端 给定字符串中任意字符
        newStr = StringUtils.stripStart(str, null);
        System.out.println(newStr);//"abc  "
        // 去右端 给定字符串中任意字符
        newStr = StringUtils.stripEnd(str, "");
        System.out.println(newStr);//" abc  "
    }

    @Test
    public void splitTest() {
        String str = "a b      c  ";
        String str2 = "a,b,c,";
        //按照空格分割字符串 结果为数组
        String[] split = StringUtils.split(str);
        System.out.println(Arrays.toString(split));

        // 按照某些字符分割 结果为数组，自动去除了截取后的空字符串
        String[] split1 = StringUtils.split(str2, ",");
        System.out.println(Arrays.toString(split1));
    }

    @Test
    public void subTest() {
        // 获得"ab.cc.txt"中最后一个.之前的字符串
        String s = StringUtils.substringBeforeLast("ab.cc.txt", ".");// ab.cc
        System.out.println(s);
        // 相似方法
        // 获得"ab.cc.txt"中最后一个.之后的字符串（常用于获取文件后缀名）
        String s1 = StringUtils.substringAfterLast("ab.cc.txt", ".");// txt
        System.out.println(s1);
        // 获得"ab.cc.txt"中第一个.之前的字符串
        String s2 = StringUtils.substringBefore("ab.cc.txt", ".");// ab
        System.out.println(s2);
        // 获得"ab.cc.txt"中第一个.之后的字符串
        String s3 = StringUtils.substringAfter("ab.cc.txt", ".");// cc.txt
        System.out.println(s3);
        // 获取"ab.cc.txt"中.之间的字符串
        String s4 = StringUtils.substringBetween("ab.cc.txt", ".");// cc
        System.out.println(s4);
        // 看名字和参数应该就知道干什么的了
        System.out.println(StringUtils.substringBetween("a(bb)c", "(", ")")); // bb
    }

    @Test
    public void otherTest() {
        // 首字母大写
        System.out.println(StringUtils.capitalize("test")); // Test
        // 字符串合并
        System.out.println(StringUtils.join(new String[]{"1", "2", "3"}, ","));// 1,2,3
        // 缩写
        System.out.println(StringUtils.abbreviate("abcdefg", 6));// "abc..."
        // 判断字符串是否是数字
        System.out.println(StringUtils.isNumeric("123"));// true
        System.out.println(StringUtils.isNumeric("abc123"));// false
        System.out.println(StringUtils.isNumeric("123abc"));// false
        // 删除指定字符
        System.out.println(StringUtils.remove("abbc", "b")); // ac
        // ... ... 还有很多，感兴趣可以自己研究
    }

    @Test
    public void randomTest() {
        // 随机生成长度为5的字符串
        System.out.println(RandomStringUtils.random(5));//𗣐𥨘▔
        // 随机生成长度为5的"只含大小写字母"字符串
        System.out.println(RandomStringUtils.randomAlphabetic(5));//dLzFb
        // 随机生成长度为5的"只含大小写字母和数字"字符串
        System.out.println(RandomStringUtils.randomAlphanumeric(5));//buSG7
        // 随机生成长度为5的"只含数字"字符串
        System.out.println(RandomStringUtils.randomNumeric(5));//48884
    }
}