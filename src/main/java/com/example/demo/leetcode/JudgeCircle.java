package com.example.demo.leetcode;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName JudgeCircle
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/28 15:32
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }
        int level = 0;
        int vertical = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'R':
                    level++;
                    break;
                case 'L':
                    level--;
                    break;
                case 'U':
                    vertical++;
                    break;
                default:
                    vertical--;
                    break;
            }
        }
        return level == 0 && vertical == 0;
    }

    @Test
    public void test() throws InterruptedException {
        assert judgeCircle("LR");
        AtomicInteger a = new AtomicInteger(0);
        a.getAndIncrement();
        ReentrantLock lock= new ReentrantLock();
        lock.tryLock();
        lock.wait();
        lock.notify();
    }
}
