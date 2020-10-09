package com.example.demo.leetcode.tree;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathSum
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/26 11:23
 */
public class PathSum {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        loop(new ArrayList<>(), root, sum);
        return res;
    }

    public void loop(List<Integer> list, TreeNode next, int sum) {
        if (next == null) {
            return;
        }
        sum -= next.val;
        if (next.left == null && next.right == null && 0 == sum) {
            list.add(next.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        } else {
            list.add(next.val);
            loop(list, next.left, sum);
            loop(list, next.right, sum);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node0 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node0;

        node0 = new TreeNode(-2);
        node0.right = new TreeNode(-3);
        List<List<Integer>> lists = pathSum(node0, -5);
        System.out.println(lists);

    }
}
