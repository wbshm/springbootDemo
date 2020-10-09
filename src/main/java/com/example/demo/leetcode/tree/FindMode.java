package com.example.demo.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMode {
    ArrayList<Integer> list = new ArrayList<>();
    int cur;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        cur = root.val;
        loop(root);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public void loop(TreeNode root) {
        if (root == null) {
            return;
        }
        loop(root.left);
        if (cur == root.val) {
            count++;
        } else {
            cur = root.val;
            count = 1;
        }
        if (count > maxCount) {
            maxCount = count;
            list = new ArrayList<>();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        loop(root.right);
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode2.left = treeNode;
        treeNode2.right = treeNode3;
        treeNode.left = treeNode4;
        int[] mode = findMode(treeNode2);
        System.out.println(Arrays.toString(mode));
    }
}
