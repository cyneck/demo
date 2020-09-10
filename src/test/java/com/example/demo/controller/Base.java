package com.example.demo.controller;

/**
 * <p>Description: 1、静态优先，构造随后 2、无论静态还是构造，先父再子</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/27 20:51
 **/
public class Base extends BaseClass {
    public Base() {
    }

    {
        System.out.println("I’m Base class");
    }

    static {
        System.out.println("static Base");
    }

    public static void main(String[] args) {
        new Base();
    }

}
