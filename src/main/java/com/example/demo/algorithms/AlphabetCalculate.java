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
        System.out.println("sum:" + FromNumberSystem26("cb"));
        System.out.println("sum:" + ToNumberSystem26(53));
        System.out.println("sum:" + ToNumberSystem26(sum));
    }


    /**
     * 将指定的26进制表示转换为自然数。映射关系：[a-z] ->[0-25]。
     * cb  ->  c*26^1+b*26^0   -> 2*26^1+ 1*26^0 = 53
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
//            i为字符串的索引，j为周期[1,26,52...]
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
     * 取余数法：整数%进制大小，得余数，由下到上组成即为对应进制数值
     *
     * @param n
     * @return
     */
    public static String ToNumberSystem26(int n) {
        String s = "";
        while (n > 0) {
            int m = n % 26; //求得余数
            if (m == 0) {
                m = 26;
            }
            s = (char) (m + 97) + s;

            n = n / 26;  //求模大小
        }
        return s;
    }
}