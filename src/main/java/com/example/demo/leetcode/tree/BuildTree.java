package com.example.demo.leetcode.tree;

import org.junit.Test;

import java.util.HashMap;

public class BuildTree {

    int[] post;
    int index;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        index = inorder.length;
        return loop(0, index);
    }

    public TreeNode loop(int start, int end) {
        if (index == 0 || start > end) {
            return null;
        }
        index--;
        Integer integer = map.get(post[index]);
        if (start > integer || integer > end) {
            index++;
            return null;
        }
        TreeNode next = new TreeNode(post[index]);
        next.right = loop(map.get(post[index]) + 1, end);
        next.left = loop(start, map.get(post[index]) - 1);
        return next;
    }

    @Test
    public void test() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
//        inorder = new int[]{9,4};
//        postorder = new int[]{9,4};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
