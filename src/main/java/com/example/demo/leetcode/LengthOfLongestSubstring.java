package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/9 22:14
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        String maxSub = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            maxSub = add(maxSub, s.charAt(i));
            res = Math.max(res, maxSub.length());
            if (maxSub.length() + len - i <= res) {
                break;
            }
        }
        return res;
    }

    public String add(String str, char s) {
        /**
         * indexOf 可以转换成数组。这样就可以省去搜搜时间。
         */
        int index = str.indexOf(s);
        if (index == str.length() - 1) {
            return s + "";
        } else if (index >= 0) {
            return str.substring(index + 1) + s;
        } else {
            return str + s;
        }
    }

    @Test
    public void test() {
        String input = "aaavasca";
        int i = lengthOfLongestSubstring(input);
        System.out.println(i);
    }
}
