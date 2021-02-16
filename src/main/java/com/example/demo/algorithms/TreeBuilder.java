package com.example.demo.algorithms;

import java.util.*;

import org.junit.Test;

/**
 * <p>Description: 二插树构建</p>
 *
 * @author Eric Lee
 * @version v1.0.0
 * @since 2021/2/17 00:33
 **/

public class TreeBuilder {

    private static int sum = 0;
    private static int size = 0;

    @Test
    public void test() {
        /**
         *          1
         *      2       3
         *    4   5   6
         */
        TreeNode treeNode = arrayToBTree(new Integer[]{1, 2, 3, 4, 5, 6});

//        preOrderTraverse1(treeNode);
//        System.out.println("sum:" + sum + ",size:" + size);
        preOrderTraverse2(treeNode);
        System.out.println("sum:" + sum + ",size:" + size);
    }

    // 递归
    // 先序遍历, 先根节点，再左子树，最后右子树
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            sum = sum + root.data;
            size = size + 1;
            System.out.print(root.data + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    // 栈实现先序遍历
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                sum = sum + node.data;
                size = size + 1;
                System.out.print(node.data + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popNode = stack.pop();
                node = popNode.right;
            }
        }
    }

    // 层序遍历
    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + "->");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    class TreeNode {
        Integer data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Integer data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return this.data + "[" + this.left + "," + this.right + "]";
        }
    }

    public TreeNode arrayToBTree(Integer[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return new TreeNode();
        }

        List<TreeNode> nodes = new ArrayList<>(arrs.length);
        for (Integer obj : arrs) {
            TreeNode treeNode = new TreeNode();
            treeNode.data = obj;
            nodes.add(treeNode);
        }

        for (int i = 0; i < arrs.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arrs.length / 2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
        if (arrs.length % 2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
        }

        return nodes.get(0);
    }

}
