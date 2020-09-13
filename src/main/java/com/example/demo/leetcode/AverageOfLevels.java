package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AverageOfLevels
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/12 8:41
 */
public class AverageOfLevels {
    List<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<TreeNode> start = new ArrayList<>(1);
        start.add(root);
        bfs(start);
        return res;
    }

    public void bfs(ArrayList<TreeNode> list) {
        ArrayList<TreeNode> next = new ArrayList<>();
        double sum = 0;
        for (TreeNode level : list) {
            sum += level.val;
            if (level.left != null) {
                next.add(level.left);
            }
            if (level.right != null) {
                next.add(level.right);
            }
        }
        res.add(sum / list.size());
        if (next.size() != 0) {
            bfs(next);
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
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        List<Double> doubles = averageOfLevels(treeNode3);
        System.out.println(doubles);
    }
}
