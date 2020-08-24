package com.example.demo.io.detail;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName BufferedTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 10:16
 */
public class BufferedTest {

    @Test
    public void testBufferedWriter() {

    }

    public void testBufferedReader() {

    }

    public void copyFile(String inputFile, String outputFile) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile))) {
            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
                byte[] bytes = new byte[1024];
                int read;
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyText(String input, String output) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                String s;
                while ((s = br.readLine()) != null) {
                    bw.write(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


