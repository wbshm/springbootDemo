package com.example.demo.aop.service;

import com.example.demo.aop.bean.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelloServiceTest {

    @Autowired
    Calculator calculator;

    @Test
    public void test() {
        calculator.div(1, 1);
    }

}
