package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @ClassName LevelOrderBottom
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/6 9:26
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> next = new LinkedList<>();
        next.add(root);
        List<List<Integer>> res = new ArrayList<>();
        loop(next, res);
        Collections.reverse(res);
        return res;
    }


    public void loop(LinkedList<TreeNode> list, List<List<Integer>> res) {
        LinkedList<TreeNode> next = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode pop = list.pop();
            arrayList.add(pop.val);
            if (pop.left != null) {
                next.add(pop.left);
            }
            if (pop.right != null) {
                next.add(pop.right);
            }
        }
        res.add(arrayList);
        if (!next.isEmpty()) {
            loop(next, res);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> lists = levelOrderBottom(null);
        System.out.println(lists);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
