package com.example.demo.controller;

/**
 * <p>Description: java命令执行方式</p>
 * 编译后用cmd输入"java Test one two three"调用，输出one
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/27 21:44
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
