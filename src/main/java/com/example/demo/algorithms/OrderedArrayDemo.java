package com.example.demo.algorithms;

/**
 * <p>Description: </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/1/26 15:16
 **/
public class OrderedArrayDemo {
    public static void main(String[] args) {

        binarySearch();

    }


    public static void binarySearch() {
        int[] array = {2, 5, 6, 8, 9, 10, 14, 18, 20};
        int index = iterationSearch(array, 6);
        System.out.println(index);

    }

    /**
     * 递归查找
     *
     * @return
     */
    public static int recursionSearch(int[] data, int value) {

        return -1;
    }

    /**
     * 迭代查找
     *
     * @param data
     * @param target
     * @return
     */
    public static int iterationSearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = data[mid];
            if (value == target) {
                return mid;
            } else if (value < target) {
                left = mid + 1;
            } else if (value > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}
