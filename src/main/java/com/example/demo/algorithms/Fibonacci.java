package com.example.demo.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Package : com.example.demo.algorithms
 * Description : 斐波那契额数列，求第n个值是多少？
 * F(n) = n; n = 0,1
 * F(n) = F(n-1) + F(n-2),n >= 2;
 * 例如：0，1，1，2，3，5，8...
 * Create on : 2018/12/4 16:12 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Fibonacci {

    public static void main(String[] args) throws Exception {

        StringBuilder resultStr1 = new StringBuilder();
        StringBuilder resultStr2 = new StringBuilder();
        StringBuilder resultStr3 = new StringBuilder();
        for (int n = 1; n <= 10; n++) {
            resultStr1.append(getFibonacci(n) + ",");

            resultStr2.append(getFibOptimized(n) + ",");

            resultStr3.append(getFibonacciMemo(n) + ",");
        }
        System.out.println("使用递归公式：");
        System.out.println(resultStr3.toString());
        System.out.println("使用循环迭代：");
        System.out.println(resultStr2.toString());
        System.out.println("使用Map存储值：");
        System.out.println(resultStr1.toString());


    }

    /**
     * 斐波纳切数列
     * 递归版，根据递推公式
     * 缺点：时间复杂度高
     *
     * @param n
     * @return
     */
    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    /**
     * 斐波纳切数列
     * 采用循环迭代解法，逐个前后相加求和
     * 时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    private static int getFibOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0, current = 1, next;
        n++;
        //从n=2开始循环求和
        for (int i = 2; i < n; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }


    //存储对象
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    private static int getFibonacciMemo(int n) {
        getFibona(n);
        return fibBotUp(n);
    }

    /**
     * 斐波那契数列
     * 记住第n个，规避重复递归计算
     *
     * @param n
     * @return
     */
    private static int getFibona(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int f;
        if (n <= 2) {
            f = 1;
        } else {
            f = getFibona(n - 1) + getFibona(n - 2);
            map.put(n, f);
        }
        return f;
    }


    /**
     * 斐波纳契数
     * 自下而上查找
     *
     * @param n
     * @return
     */
    private static int fibBotUp(int n) {
        Map<Integer, Integer> fib = new HashMap<Integer, Integer>();

        for (int i = 1; i < n + 1; i++) {
            int f = 1;
            if (i <= 2) {
                f = 1;
            } else {
                f = fib.get(i - 1) + fib.get(i - 2);
            }
            fib.put(i, f);
        }
        return fib.get(n);
    }


}
