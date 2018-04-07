package com.example.shuati.niukewang.test;

public class StringCompare {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a == b);

        String c =new String("hello");
        String d = new String("hello");
        System.out.println(c == d);

        System.out.println(a == c);
    }
}
