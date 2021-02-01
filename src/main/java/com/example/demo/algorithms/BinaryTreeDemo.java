package com.example.demo.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/2 00:11
 **/
public class BinaryTreeDemo {

    //    存节点
    public static List<BinaryTree> datas;

    public static void main(String[] args) {
        BinaryTree bintree = new BinaryTree();
        Object[] a = {2, 4, 5, 7, 1, 6, 12, 32, 51, 22};
        bintree.creat(a);
        bintree.preOrder(bintree.root);
    }

    static class BinaryTree {
        private Object data;
        private BinaryTree root;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(Object data, BinaryTree left, BinaryTree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public BinaryTree(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryTree() {
        }

        /**
         * 先序遍历
         * @param root
         */
        public void preOrder(BinaryTree root) {
            if (root != null) {
                System.out.println(root.data);
                preOrder(root.left);
                preOrder(root.right);
            }

        }

        public void midOrder(BinaryTree root) {

        }

        public void postOrder(BinaryTree root) {

        }

        public void creat(Object[] objs) {
            datas = new ArrayList<>();
            // 将一个数组的值依次转换为Node节点
            for (Object o : objs) {
                datas.add(new BinaryTree(o));
            }
            // 第一个数为根节点
            root = datas.get(0);
            // 建立二叉树
            for (int i = 0; i < objs.length / 2; i++) {
                // 左孩子
                datas.get(i).left = datas.get(i * 2 + 1);
                // 右孩子
                if (i * 2 + 2 < datas.size()) {
                    //避免偶数的时候 下标越界
                    datas.get(i).right = datas.get(i * 2 + 2);
                }
            }

        }
    }
}
