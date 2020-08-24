package com.example.demo.io.detail;

import com.example.demo.io.Config;
import org.junit.Test;

import java.io.*;

/**
 * @ClassName FileReaderDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 8:55
 */
public class FileReaderDemo {

    @Test
    public void testFileReader() throws IOException {
        File file = new File(Config.inputPath);
        FileReader fr = new FileReader(file);

        char[] buff = new char[1 << 10 << 8];
        int len;
        while ((len = fr.read(buff)) != -1) {
            System.out.println(new String(buff, 0, len));
        }
        fr.close();
    }

    @Test
    public void testFileRead1() throws IOException {
        File file = new File(Config.inputPath);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void testFileWriter() {
        File file = new File(Config.outputPath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("nihao");
            bw.newLine();
            bw.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
