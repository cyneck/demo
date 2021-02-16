package com.example.demo.algorithms;

/**
 * <p>Description: 字典序组合排序</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/15 22:12
 **/
public class LexicograhicPermutationSolution {
    public static void main(String[] args) {
//        int[] list = {1, 2, 3};
//        Prim(list);

        int[] A = {1, 3, 4, 2};
        int[] R = nextPermutation(A);
    }


    //给定一个数组，计算它的字典序的下一个排序
    static int[] nextPermutation(int[] A) {
        int n = A.length;
        int a = 0, b = 0;
        for (int i = n - 1; i > 0; --i) //从右往左，找出第一个左边小于右边的数，设为list[a]
            if (A[i - 1] < A[i]) {
                a = i - 1;
                break;
            }
        for (int j = n - 1; j > a; --j) //从右往左，找出第一个大于list[a]的数，设为list[b]
            if (A[j] > A[a]) {
                b = j;
                break;
            }
        print(A);
        Swap(A, a, b);         //交换list[a],list[b]
        print(A);
        a++;
        reverse(A, a, n - 1);
        print(A);
        return A;
    }

    // 剩余数组倒转
    public static void reverse(int[] A, int start, int end) {
        while (start < end) {
            Swap(A, start++, end);
        }
    }

    //计算全排列
    static void Prim(int[] list) {
        int num = 1;
        int a = 0, b = 0;
        int n = list.length;
        for (int i = n; i > 0; --i)     //计算有多少种情况，就循环多少次
            num *= i;   //阶乘
        while (num-- != 1) {
            //打印情况
            print(list);
            for (int i = n - 1; i > 0; --i) //从右往左，找出第一个左边小于右边的数，设为list[a]
                if (list[i - 1] < list[i]) {
                    a = i - 1;
                    break;
                }
            for (int j = n - 1; j > a; --j) //从右往左，找出第一个大于list[a]的数，设为list[b]
                if (list[j] > list[a]) {
                    b = j;
                    break;
                }
            Swap(list, a, b);         //交换list[a],list[b]
            Sort(list, a, n);         //将list[a]后面的数据，由小往大排列
        }
        //打印情况
        print(list);
        return;
    }


    //将list区间[a,n]之间的数据由小到大排序
    static void Sort(int[] list, int a, int n) {
        int temp = 0;
        for (int i = 1; i < n - a; ++i)
            for (int j = a + 1; j < n - 1; ++j)
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
        return;
    }

    static void print(int[] list) {
        String result = "";
        for (int item : list) {
            result += item;

        }
        System.out.println(result);
    }

    //交换list[a],list[b]
    public static void Swap(int[] list, int a, int b) {
        int temp = 0;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
        return;
    }
}
