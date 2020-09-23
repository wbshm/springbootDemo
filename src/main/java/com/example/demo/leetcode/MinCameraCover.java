package com.example.demo.leetcode;

import org.junit.Test;

/**
 * todo doing
 */
public class MinCameraCover {

    int loop = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        loop(root, false);
        int sum = loop;
        loop = 0;
        loop(root, true);
        return sum != 0 ? Math.min(sum, loop) : loop;
    }

    public void loop(TreeNode next, boolean check) {
        if (next == null) {
            return;
        }
        if (check) {
            loop(next.left, false);
            loop(next.right, false);
            loop++;
        } else {
            loop(next.left, true);
            loop(next.right, true);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.left = treeNode5;


        int i = minCameraCover(treeNode);
        System.out.println(i);
    }
}
