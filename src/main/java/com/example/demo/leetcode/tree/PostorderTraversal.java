package com.example.demo.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostorderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Boolean> check = new ArrayList<>();
    ArrayList<TreeNode> node = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        node.add(root);
        check.add(false);
        list = new ArrayList<>();
        while (!node.isEmpty()) {
            TreeNode remove = node.remove(0);
            boolean checked = check.remove(0);
            if (remove == null) {
                continue;
            }
            if (checked) {
                list.add(remove.val);
            } else {
                node.add(remove.right);
                check.add(false);
                node.add(remove.left);
                check.add(false);
                node.add(remove);
                check.add(true);
            }
        }
        Collections.reverse(list);
        return list;
    }


    public void loop(TreeNode root) {

    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node2.left = node3;
        node.right = node4;
        System.out.println(node);

        List<Integer> integers = postorderTraversal(node);
        List<Integer> integers1 = postorderTraversal1(node);
        System.out.println(integers);
        System.out.println(integers1);
    }
}