package com.example.demo.leetcode.tree;

import org.junit.Test;

public class GetMinimumDifference {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (ans == 1) {
            return;
        }
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(12);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(18);
        TreeNode node3 = new TreeNode(13);

        node.left = node1;
        node.right = node2;
        node2.left = node3;
        int minimumDifference = getMinimumDifference(node);
        System.out.println(minimumDifference);
    }
}
