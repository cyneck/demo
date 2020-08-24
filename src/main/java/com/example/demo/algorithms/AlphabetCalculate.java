package com.example.demo.algorithms;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * <p>Description: 字母加减运算(26进制计算,0-25) </p>
 * 例如：
 * add b
 * add z
 * =
 * 26
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/24 13:44
 **/
public class AlphabetCalculate {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum = 0;
        String current = "";
        while (!current.equals("=")) {
            current = reader.nextLine();
            String[] numStr = current.split(" ");
            if (numStr.length == 2) {
                String symbol = numStr[0];
                String b = numStr[1];
                String result = "";
                if (symbol.equals("add")) {
                    sum = sum + FromNumberSystem26(b);
                } else if (symbol.equals("sub")) {
                    sum = sum - FromNumberSystem26(b);
                }
            }
        }
        System.out.println("sum:" + sum);
    }


    /**
     * 将指定的26进制表示转换为自然数。映射关系：[a-z] ->[0-25]。
     *
     * @param s
     * @return
     */
    public static int FromNumberSystem26(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        int n = 0;
        for (int i = s.length() - 1, j = 1; i >= 0; i--, j *= 26) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') {
                return 0;
            }
            n += ((int) c - 97) * j;
        }
        return n;
    }

    /**
     * 将指定的自然数转换为26进制表示。映射关系：[0-25] ->[a-z]
     *
     * @param n
     * @return
     */
    public static String ToNumberSystem26(int n) {
        String s = "";
        while (n > 0) {
            int m = n % 26;
            if (m == 0) m = 26;
            s = (char) (m + 64) + s;
            n = (n - m) / 26;
        }
        return s;
    }
}