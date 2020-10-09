package com.example.demo.leetcode.node;

import org.junit.Test;

import java.util.ArrayList;

public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);
        loop(list);
        return root;
    }

    public void loop(ArrayList<Node> list) {
        if (list.isEmpty()) {
            return;
        }
        Node cur = list.get(0);
        ArrayList<Node> next = new ArrayList<>();
        if (cur.left != null) {
            next.add(cur.left);
        }
        if (cur.right != null) {
            next.add(cur.right);
        }
        for (int i = 1; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = list.get(i);
            if (cur.left != null) {
                next.add(cur.left);
            }
            if (cur.right != null) {
                next.add(cur.right);
            }
        }
        loop(next);
    }

    @Test
    public void test() {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.left = node2;
        node.right = node3;

        Node connect = connect(node);
        System.out.println(connect);
    }
}
