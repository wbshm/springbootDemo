package com.example.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName ShortestPalindrome
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/29 8:17
 */
public class ShortestPalindrome {
    List<int[]> list = new ArrayList<>();
    String s = "";

    public String shortestPalindrome(String s) {
        this.s = s;
        if (s == null || s.length() == 0) {
            return Objects.isNull(s) ? null : "";
        }
        int left = 0;
        int right = s.length() - 1;
        int start = 1;
        int status;
        addKey(left);
        while (right > 0) {
            status = 0;
            while (s.charAt(left) == s.charAt(right)) {
                status = 2;
                if (left + 1 >= right) {
                    start = left != right ? (left + 1) * 2 : left * 2 + 1;
                    status = 1;
                    break;
                } else {
                    left++;
                    right--;
                    addKey(left);
                }
            }
            if (status == 2 && left > 0) {
                int[] ints = list.get(left - 1);
                left = ints[1];
                right++;
            }
            if (status == 0) {
                left = 0;
            }
            if (status == 1 || left + 1 >= right) {
                break;
            }
            right--;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = start; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }

    public void addKey(int index) {
        if (index != list.size()) {
            return;
        }
        int[] cur = new int[2];
        char c = this.s.charAt(index);
        cur[0] = c;
        if (list.size() == 0) {
            list.add(index, cur);
            return;
        }
        int[] last = list.get(index - 1);
        int value;
        int[] first = list.get(0);
        if (last[1] == 0) {
            value = first[0] == c ? 1 : 0;
        } else {
            int[] tmp = list.get(last[1]);
            value = tmp[0] == c ? (last[1] + 1) : (first[0] == c ? 1 : 0);
        }
        cur[1] = value;
        list.add(index, cur);
    }

    @Test
    public void testKey() {
        this.s = "ababab";
        for (int i = 0; i < s.length(); i++) {
            addKey(i);
        }
    }

    @Test
    public void test() {
        String avb = shortestPalindrome("aacecaaa");
        System.out.println(avb);
        Assert.assertEquals("aaacecaaa", avb);

        avb = shortestPalindrome("babbbabbaba");
        System.out.println(avb);
        Assert.assertEquals("ababbabbbabbaba", avb);
    }
}
