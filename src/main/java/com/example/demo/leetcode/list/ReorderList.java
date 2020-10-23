package com.example.demo.leetcode.list;

import org.junit.Test;

import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode loop = head;
        while (loop != null) {
            linkedList.push(loop);
            loop = loop.next;
        }
        loop = head;
        int count = 0;
        linkedList.removeLast();
        while (!linkedList.isEmpty()) {
            count++;
            if (count % 2 == 0) {
                loop.next = new ListNode(linkedList.removeLast().val);
            } else {
                loop.next = new ListNode(linkedList.pop().val);
            }
            loop = loop.next;
        }
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(null);
        System.out.println(node1);
    }
}
