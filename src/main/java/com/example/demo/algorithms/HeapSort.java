package com.example.demo.algorithms;

import java.util.Arrays;

/**
 * <p>Description: 堆排序代码实现升序、降序排序 </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/20 00:26
 **/

public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {4,6,8,5,9,-1,10,-999};
        //测试升序
        //heapSort(arr);
        // System.out.println(Arrays.toString(arr));

        //测试降序
        heapSortMaxDown(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int [] arr){
        int length = arr.length;
        int temp = 0;

        //第一次调整,从第一个非叶子结点（下标为arr.length / 2 - 1）开始调整
        for(int i = length / 2 - 1; i >= 0; i--){
            adjustHeapMax(arr,i,length);
        }

        for(int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];//把最大值交换到末尾
            arr[0] = temp;
            adjustHeapMax(arr,0,j);//从第二次开始，每次都是从根节点(0)开始调整
        }
    }

    //最大堆（升序）,最小堆（降序）
    /**
     *
     * @param arr 排序数组
     * @param i  完成以i 对应的非叶子结点的树调成大顶堆
     * @param length 调整的长度
     */
    //调整成最大堆
    public static void adjustHeapMax(int [] arr, int i, int length){
        int temp = arr[i];

        //2 * i + 1 --> i 结点的左子节点（如果存在）， 2 * i + 2 -->i 结点的右子结点的下标（如果存在）
        for(int k = 2 * i + 1; k < length; k = 2 * k + 1){
            if(k + 1 < length && arr[k] < arr[k+1]){//左子节点的值 < 右子结点的值
                k++;
            }
            //判断是否交换
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;// i 指向 k 继续循环
            }else {
                break;//说明此子树已经不用调整,因为调整顺序为从左至右，从下至上
            }
        }
        //for 循环结束后，已经将以 i 为父结点的树的最大值，放在了最顶（父结点),局部最大
        arr[i] = temp;//将temp放到被调整的位置
    }

    //降序排序
    public static void heapSortMaxDown(int [] arr){
        int temp = 0;
        int length = arr.length;

        for(int i = length / 2 - 1; i >= 0; i--){
            heapAdjustMin(arr,i,length);
        }

        for(int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];//把最小值提到末尾
            arr[0] = temp;
            heapAdjustMin(arr,0,j);
        }

    }

    //调整成最小堆
    public static void heapAdjustMin(int [] arr, int i, int length){
        int temp = arr[i];

        for (int k = 2 * i + 1; k < length; k = k * 2 + 1){
            if(k + 1 < length && arr[k] > arr[k + 1]){
                k++;
            }
            //和父结点比较大小，判断是否需要交换
            if(temp > arr[k]){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }

        arr[i] = temp;
    }
}
