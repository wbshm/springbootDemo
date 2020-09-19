package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName InvertTree
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/16 7:46
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        revert(root);
        return root;
    }

    public void revert(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            revert(root.right);
            revert(root.left);
        }
    }


    @Test
    public void test() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;

        TreeNode node = invertTree(node4);
        System.out.println(node);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
