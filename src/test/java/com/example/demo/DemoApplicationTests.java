package com.example.demo;

import com.example.demo.aop.bean.Calculator;
import com.example.demo.tx.TxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Calculator calculator;

    @Autowired
    TxService txService;

    @Test
    void contextLoads() {
        calculator.div(1, 1);
        calculator.div(1, 0);
    }

    @Test
    void test() {
        try {
            txService.exchange();
        } finally {
            System.out.println(txService.getMoneyA());
            System.out.println(txService.getMoneyB());
        }
    }

}
