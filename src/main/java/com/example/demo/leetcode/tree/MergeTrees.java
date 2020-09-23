package com.example.demo.leetcode.tree;

import org.junit.Test;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 != null) {
            if (t1 == null) {
                t1 = new TreeNode(0);
            }
            t1.val += t2.val;
            if (t1.left == null && t2.left != null) {
                t1.left = new TreeNode(0);
            }
            if (t1.right == null && t2.right != null) {
                t1.right = new TreeNode(0);
            }
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t5 = new TreeNode(5);

        t1.left = t3;
        t1.right = t2;
        t3.left = t5;


        TreeNode s2 = new TreeNode(2);
        TreeNode s1 = new TreeNode(1);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s7 = new TreeNode(7);

        s2.left = s1;
        s2.right = s3;
        s1.right = s4;
        s3.right = s7;

        TreeNode treeNode = mergeTrees(t1, s2);
        System.out.println(treeNode);

    }
}
