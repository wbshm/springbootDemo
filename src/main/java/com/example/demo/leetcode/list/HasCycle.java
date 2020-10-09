package com.example.demo.leetcode.list;

import org.junit.Test;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean isLoop = false;
        ListNode slow = head;
        ListNode fast = head.next;
        int count = 0;
        while (true) {
            if (slow == null || fast == null) {
                break;
            }
            if (slow == fast) {
                isLoop = true;
                break;
            }
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return isLoop;
    }

    @Test
    public void test() {

    }
}
