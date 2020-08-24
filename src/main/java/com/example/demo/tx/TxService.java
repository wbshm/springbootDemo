package com.example.demo.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TxService
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/23 15:26
 */
@Service
public class TxService {
    private int moneyA = 1000;
    private int moneyB = 1000;

    @Transactional(rollbackFor = {Exception.class}, noRollbackFor = {Throwable.class})
    public void exchange() {
        moneyA -= 100;
        int i = 100 / 0;
        moneyB += 100;
    }

    public int getMoneyA() {
        return moneyA;
    }

    public int getMoneyB() {
        return moneyB;
    }
}
