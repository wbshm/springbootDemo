package com.example.demo.io.detail;

import com.example.demo.io.Config;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileInputOutPutSteamTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 9:45
 */
public class FileInputOutPutSteamTest {


    @Test
    public void testFileInputSteam() throws IOException {
        File file = new File(Config.inputPath);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[5];
        int read;
        while ((read = inputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, read));
        }
    }


    @Test
    public void testFileCopy() {
        long start = System.nanoTime();
        fileCopy("C:\\Users\\wangrq\\Desktop\\zookeeper视频.zip", "C:\\Users\\wangrq\\Desktop\\zookeeper-1.zip");
        System.out.println(System.nanoTime() - start);
    }

    public void fileCopy(String filePath, String outputFile) {

        try (FileInputStream fr = new FileInputStream(filePath)) {
            try (FileOutputStream fw = new FileOutputStream(outputFile)) {
                byte[] buff = new byte[1024];
                int len;
                while ((len = fr.read(buff)) != -1) {
                    fw.write(buff, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
