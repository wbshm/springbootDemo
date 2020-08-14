package com.example.demo.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NameList
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/11 11:15
 */
public class NameList<T> {
    private List<T> nameList = Collections.synchronizedList(new LinkedList<T>());

    public void add(T name) {
        nameList.add(name);
    }

    public T removeFirst() {
        synchronized (this) {
            if (nameList.size() > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return nameList.remove(0);
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        final NameList<String> nl = new NameList<>();
        nl.add("Aaa");

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                String name = nl.removeFirst();
                if (name != null) {
                    System.out.println(name);
                }
            });
        }

        exec.shutdown();
    }

}
