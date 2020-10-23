package com.example.demo.leetcode.list;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            ListNode temp = slow.next;
            if(pre != null) slow.next = pre;
            pre = slow;
            fast = fast.next.next;
            slow = temp;
        }
        if(fast != null) slow = slow.next;
        while(slow != null){
            if(slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
