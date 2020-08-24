package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName LogAspects
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/20 22:58
 */
@Aspect
@Component
public class LogAspects {
    @Pointcut(value = "execution(public int com.example.demo.aop.bean.Calculator.*(..))")
    public void pointCut() {
    }

    @Before(value = "execution(public int com.example.demo.aop.bean.Calculator.*(..))")
    public void logStart() {
        System.out.println("start");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println(joinPoint.getSignature().getName() + ": logEnd");
    }

    @AfterReturning(value = "pointCut()", returning = "res")
    public void logReturn(Object res) {
        System.out.println("logReturn : " + res);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("logException" + exception);
    }
}
