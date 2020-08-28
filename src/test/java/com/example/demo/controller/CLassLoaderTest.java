package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * <p>Description: CLassLoaderTest </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/28 16:35
 **/
public class CLassLoaderTest {
    public static void main(String[] args) throws Exception {
//        ArrayList<String> l1 = new ArrayList<String>();
//        ArrayList<Integer> l2 = new ArrayList<Integer>();
//        l1.add("1");
//        l2.add(1);
//        System.out.println(l1.get(0).getClass());
//        System.out.println(l2.get(0).getClass());
//        System.out.println(l1.getClass() == l2.getClass());
        test("");

    }

    private static final ArrayList<String> list = new ArrayList<>();

    public static String test(String j) {
        int i = 1, s = 1, f = 1, a = 1, b = 1, c = 1, d = 1, e = 1;
        list.add(new String("11111111111111111111111111111"));
        return test(s + i + f + a + b + c + d + e + "");
    }
}
