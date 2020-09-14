package com.example.demo.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName InorderTraversal
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/14 7:42
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        add(res, root);
        return res;
    }

    public void add(List<Integer> res, TreeNode node) {
        if (node != null) {
            add(res, node.left);
            res.add(node.val);
            add(res, node.right);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> linked = new LinkedList<>();
        LinkedList<Boolean> isCheck = new LinkedList<>();
        linked.push(root);
        isCheck.push(false);
        boolean is;
        while (!linked.isEmpty()) {
            TreeNode pop = linked.pop();
            is = isCheck.pop();
            if (pop == null) {
                continue;
            }
            if (is) {
                res.add(pop.val);
            } else {
                linked.push(pop.right);
                isCheck.push(false);
                linked.push(pop);
                isCheck.push(true);
                linked.push(pop.left);
                isCheck.push(false);
            }
        }
        return res;
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
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.right = node2;
        node2.left = node3;
        List<Integer> integers = inorderTraversal2(node);
        System.out.println(integers);
    }
}
