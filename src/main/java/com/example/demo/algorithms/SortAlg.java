package com.example.demo.algorithms;

/**
 * <p>Description: 排序算法</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2020/8/19 15:54
 **/
public class SortAlg {
    public static void main(String[] args) {
        //冒泡排序算法
        int[] numbers = new int[]{1, 5, 8, 2, 3, 9, 4};
        int i, j;
        for (i = 0; i < numbers.length - 1; i++) {
            for (j = 0; j < numbers.length - 1 - i; j++) {
                int pre = numbers[j];
                int post = numbers[j + 1];
                if (pre > post) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.print(numbers);
    }
}
