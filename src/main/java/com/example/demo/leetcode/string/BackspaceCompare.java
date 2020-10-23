package com.example.demo.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        ArrayList<Character> listS = new ArrayList<>(S.length());
        ArrayList<Character> listT = new ArrayList<>(T.length());
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                listS.add(c);
            } else if (listS.size() - 1 >= 0) {
                listS.remove(listS.size() - 1);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#') {
                listT.add(c);
            } else if (listT.size() - 1 >= 0) {
                listT.remove(listT.size() - 1);
            }
        }
        if (listS.size() != listT.size()) {
            return false;
        } else {
            for (int l = 0; l < listS.size(); l++) {
                if (listS.get(l) != listT.get(l)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean b = backspaceCompare("av##", "a#v#");
        System.out.println(b);
    }
}
