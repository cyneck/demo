package com.example.demo.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Package : com.example.demo.algorithms Description : 约瑟夫问题，循环删除2个间隔之间的数
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数， 到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 **/
public class LastNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();// 输入一个整数
        System.out.println(lastNum3(num));
    }

    public static int lastNum1(int input) {
        int left = input; // 剩余个数
        boolean flag[] = new boolean[input];// 用来标记是否删除了这个数
        int num = 0;// 用来计数
        int result = 0;
        for (int i = 0; i < input; i++) {
            num++;
            if (!flag[i]) {
                if (num % 3 == 0) {
                    flag[i] = true;
                    left--;
                }
                if (left == 1) {
                    break;
                }
            } else {
                num--;
            }
            if (i + 1 == input) {
                i = -1;
            }
        }
        for (int j = 0; j < input; j++) {// 找出最后那个数，为false的索引
            if (!flag[j]) {
                result = j;
                break;
            }
        }
        return result;
    }

    public static int lastNum2(int input) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < input; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();
            list.remove(i);
        }

        return (int) list.get(0);
    }

    // 约瑟夫环问题， 递推公式：f[1] = 0 ，f[i] = (f[i - 1] + K) mod i
    public static int lastNum3(int n) {
        int rest = 0;
        for (int i = 2; i <= n; i++) {
            rest = (rest + 3) % i;
        }
        return rest;
    }


}