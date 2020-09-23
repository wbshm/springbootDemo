package com.example.demo.leetcode.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (left == null && right == null) {
            return "" + val;
        }
        return "" + val +
                " -> (L=" + left +
                ", R=" + right + ")";
    }
}
