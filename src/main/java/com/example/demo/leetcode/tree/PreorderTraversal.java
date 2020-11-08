package com.example.demo.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        loop(root);
        return res;
    }

    public void loop(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            loop(root.left);
            loop(root.right);
        }
    }
}
