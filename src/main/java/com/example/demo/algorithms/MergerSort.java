package com.example.demo.algorithms;

import java.util.Arrays;

/**
 * <p>Description: 归并排序</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/3/6 15:21
 **/

public class MergerSort {

    public static void main(String[] args) {
        int[] array = {58, 48, 69, 87, 49, 59, 25, 35, 68, 48};
//        sort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) >> 1;
        // 递归实现归并排序
        sort(array, start, mid);
        sort(array, mid + 1, end);
        mergerSort(array, start, mid, end);
    }

    // 将两个有序序列归并为一个有序序列(二路归并)

    /**
     * 归并排序算法
     *
     * @param array 数组
     * @param start 左边下标
     * @param mid   中间下标
     * @param end   右边下标
     */
    private static void mergerSort(int[] array, int start, int mid, int end) {
        // TODO Auto-generated method stub
        int[] arr = new int[end + 1]; // 定义一个临时数组，用来存储排序后的结果
        int low = start; // 临时数组的索引
        int left = start;

        int center = mid + 1;
        // 取出最小值放入临时数组中
        while (start <= mid && center <= end) {
            arr[low++] = array[start] > array[center] ? array[center++] : array[start++];
        }

        // 若还有段序列不为空，则将其加入临时数组末尾

        while (start <= mid) {
            arr[low++] = array[start++];
        }
        while (center <= end) {
            arr[low++] = array[center++];
        }

        // 将临时数组中的值copy到原数组中
        for (int i = left; i <= end; i++) {
            array[i] = arr[i];
        }
    }


    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j];
        }
        L[n1 + 1] = -1;
        R[n2 + 1] = -1;
        int i = 2;
        int j = 2;
        for (int k = p; k < r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else if (A[k] == R[j]) {
                j++;
            }
        }
    }

    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

}
