package com.example.demo.leetcode;

import org.junit.Test;

/**
 * @ClassName CefangIPaddr
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/26 16:38
 */
public class CefangIPaddr {

    public String solution(String address) {
        return address.replace(".", "[.]");
    }


    @Test
    public void test() {
        String input = "1.1.1.1";
        assert "1[.]1[.]1[.]1".equals(solution(input));


        input = "255.100.50.0";
        assert "255[.]100[.]50[.]0".equals(solution(input));
    }
}
