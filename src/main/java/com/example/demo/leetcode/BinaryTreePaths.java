package com.example.demo.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName BinaryTreePaths
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/4 21:01
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<List<Object>> lists = new LinkedList<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add(root);
        lists.add(arrayList);
        TreeNode loop;
        ArrayList<String> rtn = new ArrayList<>();
        while (!lists.isEmpty()) {
            List<Object> pop = lists.pop();
            String key = pop.get(0).toString();
            loop = (TreeNode) pop.get(1);
            while (loop != null) {
                if (key.length() == 0) {
                    key += loop.val;
                } else {
                    key += "->" + loop.val;
                }
                if (loop.left != null) {
                    if (loop.right != null) {
                        arrayList = new ArrayList<>();
                        arrayList.add(key);
                        arrayList.add(loop.right);
                        lists.add(arrayList);
                    }
                    loop = loop.left;
                } else if (loop.right != null) {
                    loop = loop.right;
                } else {
                    rtn.add(key);
                    break;
                }
            }
        }
        return rtn;
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
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode1.right = treeNode3;
        treeNode.right = treeNode2;
        binaryTreePaths(treeNode);
    }
}

