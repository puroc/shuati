package com.example.shuati.niukewang.offer;

import org.junit.Test;

public class T2 {
    //请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

    private StringBuffer str = new StringBuffer("hello world");

    @Test
    public void test() {
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(StringBuffer str) {
        System.out.println(str);
        String s = str.toString();
        return s.replace(" ","%20");
    }
}
