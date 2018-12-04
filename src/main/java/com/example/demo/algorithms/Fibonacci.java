package com.example.demo.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Package : com.example.demo.algorithms
 * Description : 斐波那契额数列
 * Create on : 2018/12/4 16:12 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class Fibonacci {

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {

        StringBuilder resultStr1 = new StringBuilder();
        StringBuilder resultStr2 = new StringBuilder();
        StringBuilder resultStr3 = new StringBuilder();
        for (int n = 1; n <= 10; n++) {
            //使用HashMap存储数列
            fibMemo(n);
            resultStr1.append(fibBotUp(n) + ",");

            resultStr2.append(fibOptimized(n) + ",");

            int fibonacci = getFibonacci(n);
            resultStr3.append(fibonacci + ",");
        }
        System.out.println("使用Map存储斐波那契数列：");
        System.out.println(resultStr1.toString());
        System.out.println("使用递归实现斐波那契数列：");
        System.out.println(resultStr2.toString());
        System.out.println("使用递归公式实现斐波那契数列：");
        System.out.println(resultStr3.toString());

    }

    /**
     * 记住第n个斐波那契数列
     *
     * @param n
     * @return
     */
    private static int fibMemo(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int f;

        if (n <= 2) {
            f = 1;
        } else {
            f = fibMemo(n - 1) + fibMemo(n - 2);
            map.put(n, f);
        }

        return f;
    }

    /**
     * 自下而上的方法找到第n个斐波纳契数
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


    /**
     * 自下而上的方法找到第n个斐波纳契数，采用递归方式
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     *          <p>
     *          This is optimized version of Fibonacci Program. Without using Hashmap and recursion.
     *          It saves both memory and time.
     *          Space Complexity will be O(1)
     *          Time Complexity will be O(n)
     *          <p>
     *          Whereas , the above functions will take O(n) Space.
     * @author Shoaib Rayeen (https://github.com/shoaibrayeen)
     **/
    private static int fibOptimized(int n) {

        if (n == 0) {
            return 0;
        }
        n++;
        int prev = 0, res = 1, next;
        for (int i = 2; i < n; i++) {
            next = prev + res;
            prev = res;
            res = next;
        }
        return res;
    }

    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
