package com.example.demo.thread;

import org.apache.logging.log4j.message.ThreadDumpMessage;

import java.util.concurrent.*;

/**
 * @ClassName ThreadUnsafeExample
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 16:09
 */
public class ThreadUnsafeExample {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        final int size = 100;
        new ThreadPoolExecutor(size, size, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        ExecutorService exec = Executors.newCachedThreadPool();
        ThreadUnsafeExample ex = new ThreadUnsafeExample();
        final int threadSize = 1000;
        CountDownLatch count = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            exec.execute(() -> {
                ex.increment();
                count.countDown();
            });
        }
        count.await();
        System.out.println(ex.getCount());
        exec.shutdown();
    }
}


