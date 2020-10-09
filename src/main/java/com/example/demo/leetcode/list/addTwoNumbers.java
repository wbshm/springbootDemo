package com.example.demo.leetcode.list;

import org.junit.Test;

public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            if (sumVal > 9) {
                carry = 1;
                sumVal -= 10;
            } else {
                carry = 0;
            }
            ListNode sumNode = new ListNode(sumVal);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);


        ListNode listNode = addTwoNumbers(l2, l1);
        System.out.println(listNode);

    }
}
