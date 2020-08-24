package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TreadDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/24 11:27
 */
public class TreadDemo {
    public static void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (run) {
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        run = false;
    }

    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
