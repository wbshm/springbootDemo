package com.example.demo.leetcode.string;

import org.junit.Test;

public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int count = 0;
        int check = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            while (count < typed.length()) {
                if (typed.charAt(count) == c) {
                    check = i;
                    count++;
                    break;
                } else if (i > 0 && typed.charAt(count) == name.charAt(i - 1)) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        while (count < typed.length()) {
            if (typed.charAt(count) != name.charAt(name.length() - 1)) {
                return false;
            }
            count++;
        }
        return check == name.length() - 1;
    }

    @Test
    public void test() {
        String name = "alex", typed = "aaleex";
        name = "a";
        typed = "aaaas";
        boolean longPressedName = isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }
}
