package com.example.demo.controller;

public class JvmTest {
    public static void main(String[] args) {
        MakeOutOfMemery();


    }

    /**
     * 内存溢出测试
     * 启动参数设置为：-Xms48m -Xmx48m
     * -XX:+PrintGCDetails
     * -XX:+UseParallelOldGC
     * -XX:+HeapDumpBeforeFullGC
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=heapDump.bin
     *
     * jps 命令查看java指定java线程信息
     * jmap命令输出指定java线程的dump快照
     * 　　
     */
    public static void MakeOutOfMemery() {
        String str = "";
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            str += n + str;
            str.intern();
        }
    }


}
