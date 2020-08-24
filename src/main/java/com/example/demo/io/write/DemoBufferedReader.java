package com.example.demo.io.write;

import com.example.demo.io.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName DemoBufferedReader
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 16:40
 */
public class DemoBufferedReader {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(Config.inputPath))) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> map = new HashMap<>(1);
        map.put("123", "321");
        map.size();
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        map.forEach((key, val) -> {
            System.out.println(key);
            System.out.println(val);
        });

        map.keySet();
        map.forEach((key, val) -> System.out.println(key + val));

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            entry.getValue();
            entry.getKey();
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
    }
}
