package com.example.demo.algorithms;

import java.util.Scanner;

/**
 * Package : com.example.demo.algorithms
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/12/4 15:13 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class KadaneAlgorithm {
    /**
     * This method implements Kadane's Algorithm
     *
     * @param arr The input array
     * @return The maximum contiguous subarray sum of the array
     */
    static int largestContiguousSum(int arr[]) {
        int i, len = arr.length, cursum = 0, maxsum = Integer.MIN_VALUE;
        if (len == 0)    //empty array
            return 0;
        for (i = 0; i < len; i++) {
            cursum += arr[i];
            if (cursum > maxsum) {
                maxsum = cursum;
            }
            if (cursum <= 0) {
                cursum = 0;
            }
        }
        return maxsum;
    }

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, arr[], i;
        n = sc.nextInt();
        arr = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxContSum = largestContiguousSum(arr);
        System.out.println(maxContSum);
        sc.close();
    }
}
