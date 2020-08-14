package com.example.demo.aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName HelloServiceAop
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 9:06
 */
@Aspect
@Component
public class HelloServiceAop {
    private final ArrayList<String> arrayList = new ArrayList<>(0);

    @Pointcut(value = "execution(* com.example.demo.aop.service.impl..*.*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();
        arrayList.add(signature.getName());
        arrayList.add(signature.getDeclaringType().toString());
        arrayList.add(signature.getDeclaringTypeName());
    }

    @After("executeService()")
    public void doAfterAdvice() {
        System.out.println("after");
        System.out.println(Arrays.toString(arrayList.toArray()));
    }


}
