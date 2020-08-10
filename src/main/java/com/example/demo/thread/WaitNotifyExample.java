package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName WaitNotifyExample
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 15:50
 */
public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notify();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        WaitNotifyExample ex = new WaitNotifyExample();
        exec.execute(ex::after);
        exec.execute(ex::before);
    }
}
