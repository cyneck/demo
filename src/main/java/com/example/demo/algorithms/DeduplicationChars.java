package com.example.demo.algorithms;

import org.springframework.util.Assert;

import java.util.Scanner;

/**
 * @Auther: Eric
 * @Date: 2020/1/8 15:10
 * @Description: 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 */
public class DeduplicationChars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();// 输入一个整数
        System.out.println(func(num));
        Assert.isTrue("SoriEYVzZDtnWCFAKUONgPaplIybQHmM".equals(func("SoriEYVEzZDtnWWWoCEFAKUFYEOENgPaNplIPybEQrHmzKMPN")),"ok");
    }

    public static String func(String input) {
        if (0 < input.length() && input.length() < 100) {
            char[] charArray = input.toCharArray();
            String result = Character.toString(charArray[0]);
            for (int j = 1; j < charArray.length; j++) {
                if (!result.contains(Character.toString(charArray[j]))) {
                    result += Character.toString(charArray[j]);
                }
            }
            return result;
        }
        return "";
    }

}
