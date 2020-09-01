package com.example.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName CanVisitAllRooms
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/31 10:16
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> exist = new HashSet<>();
        if (rooms.size() == 0) {
            return true;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        int cur;
        while (!linkedList.isEmpty()) {
            cur = linkedList.pop();
            exist.add(cur);
            List<Integer> integers = rooms.get(cur);
            integers.removeAll(exist);
            linkedList.addAll(integers);
        }
        return exist.size() == rooms.size();
    }


    @Test
    public void test() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList()));
        Assert.assertTrue(canVisitAllRooms(rooms));
    }
}
