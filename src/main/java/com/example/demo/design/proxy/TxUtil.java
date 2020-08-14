package com.example.demo.design.proxy;

/**
 * @ClassName TxUtil
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 10:47
 */
public class TxUtil {
    public void beginTx() {
        System.out.println("transaction start");
    }

    public void afterTx() {
        System.out.println("transaction end");
    }
}
