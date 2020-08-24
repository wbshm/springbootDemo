package com.example.demo.thread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 22:36
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> {
            System.out.println(1);
        });
        exec.shutdown();
//
//        ThreadFactory threadFactory = Executors.defaultThreadFactory();
//        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
//                4, 1,
//                TimeUnit.SECONDS, queue, threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
//
//        for (int i = 0; i < 12; i++) {
//            executor.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(1);
//
//            });
//        }
//        executor.shutdown();
    }
}
