package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName FirstUniqChar
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/11 9:40
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char a = 'a';
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - a;
            arr[index] = arr[index] == 0 ? i + 1 : -1;
        }
        int rtn = -1;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                rtn = rtn != -1 ? Math.min(rtn, arr[i] - 1) : arr[i] - 1;
            }
        }
        return rtn;
    }

    @Test
    public void Test() {
        int loveleetcode = firstUniqChar("z");
        System.out.println(loveleetcode);

    }
}
