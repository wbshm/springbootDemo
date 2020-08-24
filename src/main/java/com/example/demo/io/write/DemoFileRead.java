package com.example.demo.io.write;

import com.example.demo.io.Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName DemoFileRead
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 16:16
 */
public class DemoFileRead {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(Config.inputPath)) {
            char[] buffer = new char[3];
            int len;
            while ((len = fileReader.read(buffer)) != -1) {
                System.out.print(Arrays.copyOfRange(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
