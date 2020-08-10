package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName JoinExample
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 15:44
 */
public class JoinExample {
    private class A extends Thread {

        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B implements Runnable {
        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        new Thread(b).start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }
}
