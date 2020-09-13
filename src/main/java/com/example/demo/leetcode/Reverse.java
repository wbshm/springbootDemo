package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName Reverse
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/11 9:30
 */
public class Reverse {
    public int reverse(int x) {
        String s = Integer.toString(x);
        s = s.replace("-", "");
        System.out.println(s);
        StringBuilder r = new StringBuilder();
        if (s.length() > Integer.toString(Integer.MAX_VALUE).length()) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            r.append(s.charAt(s.length() - i - 1));
        }
        try {
            return x < 0 ? -Integer.parseInt(r.toString()) : Integer.parseInt(r.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    @Test
    public void test() {

        System.out.println(reverse(Integer.MAX_VALUE));
    }

}
