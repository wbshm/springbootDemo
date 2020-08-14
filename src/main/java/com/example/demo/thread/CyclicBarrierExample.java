package com.example.demo.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierExample
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 16:05
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier barrier = new CyclicBarrier(totalThread);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread - 1; i++) {
            exec.execute(() -> {
                System.out.println("before");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }
        exec.shutdown();
    }
}
