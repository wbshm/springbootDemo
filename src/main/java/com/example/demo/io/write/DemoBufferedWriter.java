package com.example.demo.io.write;

import com.example.demo.io.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName DemoBufferedWriter
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 16:34
 */
public class DemoBufferedWriter {
    public static void main(String[] args) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Config.outputPath, true))) {
            bw.write("nihao");
            bw.newLine();
            bw.write("nihao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
