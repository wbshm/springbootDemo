package com.example.demo.thread;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/24 12:12
 */
public class AtomicTest {
    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndIncrement();
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndDecrement();
            }
        });


        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
