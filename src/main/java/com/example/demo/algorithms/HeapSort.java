package com.example.demo.algorithms;

import org.junit.Test;

/**
 * <p>Description: 堆排序</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/21 14:13
 **/
public class HeapSort {

    @Test
    public void test() {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};

        heapSort(a);
    }

    /**
     * 堆排序方法
     *
     * @param a
     */
    public static void heapSort(int[] a) {
        buildHeap(a);
        printArray(a);
        for (int i = a.length - 1; i > 0; i--) {
            swapArray(i, 0, a);
            adjustTopToDown(0, a, i);
        }
    }

    /**
     * 建堆方法
     *
     * @param a
     */
    public static void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            adjustTopToDown(i, a, a.length);
        }
    }

    /**
     * 调整堆方法
     *
     * @param k
     * @param a
     * @param length
     */
    public static void adjustTopToDown(int k, int[] a, int length) {
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            if (i < length - 1) {
                if (a[i] < a[i + 1]) {
                    i++;
                }
            }

            if (a[k] < a[i]) {
                swapArray(k, i, a);
                k = i;
            } else {
                break;
            }
        }
    }

    /**
     * 交换方法
     *
     * @param i
     * @param j
     * @param a
     */
    public static void swapArray(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 输出方法
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
