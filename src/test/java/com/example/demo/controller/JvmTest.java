package com.example.demo.controller;

public class JvmTest {
    public static void main(String[] args) {
//        MakeOutOfMemery();


    }

    /**
     * 内存溢出测试
     * 启动参数设置为：-Xms48m -Xmx48m -XX:+PrintGCDetails -XX:+UseParallelOldGC
     */
    public static void MakeOutOfMemery() {
        String str = "";
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            str += n + str;
            str.intern();
        }
    }


}
