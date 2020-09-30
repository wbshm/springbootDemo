package com.example.demo.leetcode.tree;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            if (root.left != null) {
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }

        if (root.val < val) {
            if (root.right != null) {
                insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
        return root;
    }
}
