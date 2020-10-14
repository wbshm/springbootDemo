package com.example.demo.leetcode.list;

import org.junit.Test;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                ListNode n = new ListNode(head.val);
                n.next = head.next.next;
                head = new ListNode(head.next.val);
                head.next = n;
                swapPairs(n.next);
            }
        }
        return head;
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
        ListNode node = swapPairs(node1);
        System.out.println(node);
    }
}
