package com.example.demo.algorithms;
import java.util.Scanner;
/**
 * @author Eric Lee
 * @version v1.0.0
 * @Package : com.example.demo.algorithms
 * @Description : 某商店规定：三个空汽水瓶可以换一瓶汽水。小明手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？（约瑟夫环/丢水娟问题）
 * @Create on : 2020/3/31 17:57
 **/
public class Josephus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();// 输入一个整数
        int count = 0;
        if (n > 0) {
            while (n > 1) {
                count += n / 3;
                n = n % 3 + n / 3;
                if (n == 2) {
                    count++;
                    n = 0;
                }
            }
        }
        System.out.println(count);
    }


}
