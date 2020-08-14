package com.example.demo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvakationHandler
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 10:48
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TxUtil txUtil = new TxUtil();
        txUtil.beginTx();
        Object result = method.invoke(target, args);
        txUtil.afterTx();
        return result;
    }
}
