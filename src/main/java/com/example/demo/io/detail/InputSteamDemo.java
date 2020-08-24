package com.example.demo.io.detail;

import org.junit.Test;
import sun.font.FontManagerNativeLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName InputSteamDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 11:25
 */
public class InputSteamDemo {

    @Test
    public static void test1() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            String data = br.readLine();
            if (!"e".equalsIgnoreCase(data) && !"exit".equalsIgnoreCase(data)) {
                System.out.println(data.toUpperCase());
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        test1();
    }
}
