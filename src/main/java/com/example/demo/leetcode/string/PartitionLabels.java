package com.example.demo.leetcode.string;

import javafx.scene.effect.Bloom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        HashMap<String, Integer> map = new HashMap<>(52);
        String min, max;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            min = "min" + c;
            if (map.containsKey(min)) {
                max = "max" + c;
                map.put(max, i);
            } else {
                map.put(min, i);
            }
        }

        int loop = 0;
        char f = S.charAt(0);
        ArrayList<Integer> a = new ArrayList<>();
        int mi = 0;
        int ma = map.getOrDefault("max" + f, -1);
        while (loop < S.length() - 1) {
            loop++;
            Integer def = map.getOrDefault("max" + S.charAt(loop), -1);
            if (ma == -1) {
                a.add(1);
                mi = loop;
                ma = def;
            } else if (loop > ma) {
                a.add(ma - mi + 1);
                mi = loop;
                ma = def;
            }
            ma = Math.max(ma, def);
        }
        if (ma == -1) {
            a.add(1);
        } else {
            a.add(S.length() - mi);
        }
        return a;
    }

    @Test
    public void test() {
        String in = "ababcbacadefegdehijhklij";
        List<Integer> integers = partitionLabels(in);
        System.out.println(integers);
    }
}
