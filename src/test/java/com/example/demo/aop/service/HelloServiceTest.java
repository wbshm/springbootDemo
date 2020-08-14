package com.example.demo.aop.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    public void test() {
        helloService.sayHello();
    }

}
