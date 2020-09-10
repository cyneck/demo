package com.example.demo.algorithms;

import java.util.Scanner;

/**
 * <p>Description: 求最长连续元音字符串</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/9/11 01:24
 **/
public class findMaxASubstr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
//        String firstLine = "asdbuiodevauufgh";
        System.out.println(findMaxASubstr(firstLine));
    }

    public static int findMaxASubstr(String word) {
        if (word.length() > 0 && word.length() <= 65535) {

            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                //滑动窗口
                for (int n = 1; n < word.length() && i + n <= word.length(); n++) {
                    String sub = word.substring(i, i + n);
                    String rest = sub.replaceAll("a|e|i|o|u|A|E|I|O|U", "");
                    if (rest.length() == 0) {
                        if (max < sub.length()) {
                            max = sub.length();
                        }
                    } else {
                        break;
                    }
                }
            }
            return max;
        }
        return 0;
    }
}
