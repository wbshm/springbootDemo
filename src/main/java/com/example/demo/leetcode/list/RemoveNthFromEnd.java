package com.example.demo.leetcode.list;

import org.junit.Test;

/**
 * @ClassName RemoveNthFromEnd
 * @Description TODO
 * @Author wangrq
 * @Date 2020/10/18 11:19
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head, 0);
        int top = size - n - 1;
        ListNode loop = head;
        int count = 0;
        if (count > top) {
            return head.next;
        }
        while (count < top) {
            count++;
            loop = loop.next;
        }
        if (loop.next != null) {
            loop.next = loop.next.next;
        }
        return head;
    }

    public int size(ListNode head, int count) {
        if (null != head) {
            count++;
            count = size(head.next, count);
        }
        return count;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        ListNode node3 = removeNthFromEnd(node1, 1);
        System.out.println(node3);
    }
}
