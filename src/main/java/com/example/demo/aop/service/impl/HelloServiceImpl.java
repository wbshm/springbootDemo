package com.example.demo.aop.service.impl;

import com.example.demo.aop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/14 9:03
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
