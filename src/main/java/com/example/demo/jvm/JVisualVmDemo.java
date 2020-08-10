package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JVisualVmDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/9 11:40
 */
public class JVisualVmDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 200; i++) {
            list.add(new Student());
        }
        int count = 0;
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(count++);
            }
        } catch (InterruptedException e) {
            System.out.println(list);
            e.printStackTrace();
        }
    }

}

class Student {

    byte[] m1 = new byte[1 << 10 << 10];
}
