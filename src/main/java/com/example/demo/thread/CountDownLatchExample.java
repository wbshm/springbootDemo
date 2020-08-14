package com.example.demo.thread;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownLatchExample
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 15:57
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread + 1; i++) {
            exec.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        exec.shutdown();
    }
}
