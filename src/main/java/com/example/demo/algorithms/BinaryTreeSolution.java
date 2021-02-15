package com.example.demo.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 二叉数</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/12 21:31
 **/
public class BinaryTreeSolution {

    public static void main(String[] args) {
        int[] A = {21, 15, 20, 14, 10, 2};
        buildMaxHeap(A);
    }


    public static void UseStackCreateBinaryTree(){

    }

    public static void PreOrderTraversal(){

    }

    public static void InOrderTraversal(){

    }


    public static void PostOrderTraversal(){

    }

    public static void LevelOrderTraversal(){

    }

    public static void PushNode(){

    }

    public static void average(){

    }




    /**
     * 维护最大堆
     *
     * @param A 数组
     * @param i 子数跟节点索引
     * @return
     */
    public static void maxHeapify(int[] A, int i) {
        i = i - 1;
        int l = 2 * i;
        int r = 2 * i + 1;
        int largest = 0;
        if (l <= A.length && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A.length && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = 0;
            tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            maxHeapify(A, largest);
        }
    }

    /**
     * 构建最大堆
     *
     * @param A
     * @return
     */
    public static void buildMaxHeap(int[] A) {
        for (int i = A.length / 2; i > 0; i--) {
            maxHeapify(A, i);
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort() {

    }


    public static class Node {
        private int element;
        private Node left_child;
        private Node right_child;

        public Node(int element) {
            this.element = element;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getLeft_child() {
            return left_child;
        }

        public void setLeft_child(Node left_child) {
            this.left_child = left_child;
        }

        public Node getRight_child() {
            return right_child;
        }

        public void setRight_child(Node right_child) {
            this.right_child = right_child;
        }
    }
}
