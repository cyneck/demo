package com.example.demo.controller;

/**
 * <p>Description: A </p>
 * 链接：https://www.nowcoder.com/questionTerminal/58c58eb54b814fd786a5517769d56123
 * 来源：牛客网
 *
 * 1、静态代码块和构造函数执行先后顺序--------->
 *                              类加载时执行顺序为父类静态代码块
 *                              ->子类静态代码块
 *                              ->初始化父类成员变量
 *                              ->父类初始化语句块
 *                              ->父类构造函数
 *                              ->初始化子类成员变量
 *                              ->子类初始化语句块
 *                              ->子类构造函数
 * 2、静态代码块只在类加载时执行一次
 * 3、子类构造函数调用时，一定会先调用父类构造函数。显式调用则会调用父类指定的构造函数，隐式调用则会调用父类无参构造函数。
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/31 12:09
 **/
class A {
    static {
        System.out.print("A");
    }

    public A() {
        System.out.print("a");
    }

    void say() {
        System.out.print("1");
    }
}

class B extends A {
    static {
        System.out.print("B");
    }

    public B() {
        System.out.print("b");
    }

    void say() {
        System.out.print("2");
    }
}

class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab.say();
        ab = new B();
        ab.say();
    }
}
