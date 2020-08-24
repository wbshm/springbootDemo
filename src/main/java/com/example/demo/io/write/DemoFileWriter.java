package com.example.demo.io.write;

import com.example.demo.io.Config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName DemoFileWriter
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 15:58
 */
public class DemoFileWriter {


    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter(Config.outputPath, true)) {
            fileWriter.append("hello world" + "\n");
            fileWriter.append("hello world" + "\n");
            fileWriter.append("hello world" + "\n");
            
            fileWriter.flush();
        }
    }
}
