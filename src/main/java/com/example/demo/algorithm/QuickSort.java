package com.example.demo.algorithm;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/28 19:50
 */
public class QuickSort {
    public int[] quickSort(int[] nums) {
        return nums;
    }

    public void test() {
        ArrayList<Integer> arrayList = new ArrayList(100);
        int[] exceptedResult = new int[100];
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
            exceptedResult[i] = i;
        }
        Collections.shuffle(arrayList);
        int[] nums = new int[100];
        for (int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.remove(0);
        }
        int[] actualResult = quickSort(nums);

        Assert.assertArrayEquals(exceptedResult, actualResult);

    }
}
