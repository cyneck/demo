package com.example.demo.base;

/**
 * <p>Description: 字符串</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/9 22:24
 **/
public class StrDemo {

    public static void main(String[] args) {
        String s = "Hello";
        String ss = s + " World";
        String sss = "Hello World";
        System.out.println(sss == ss);
        System.out.println(sss.equals(ss));
    }
}
