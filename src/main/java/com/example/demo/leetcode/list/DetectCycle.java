package com.example.demo.leetcode.list;

import java.util.HashSet;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<ListNode> list = new HashSet<>();
        ListNode n = head;
        list.add(n);
        while (n.next != null) {
            n = n.next;
            if (list.contains(n)) {
                return n;
            } else {
                list.add(n);
            }
        }
        return null;
    }

    public void test() {

    }
}
