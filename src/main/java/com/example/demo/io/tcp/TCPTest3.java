package com.example.demo.io.tcp;

import com.example.demo.io.Config;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPTest3
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 18:15
 */
public class TCPTest3 {

    @Test
    public void client() {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899)) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                try (FileInputStream fis = new FileInputStream(Config.inputPath)) {
                    byte[] buff = new byte[10];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        outputStream.write(buff, 0, len);
                    }
                    socket.shutdownOutput();
                }

                InputStream inputStream = socket.getInputStream();
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    byte[] buff = new byte[10];
                    int len;
                    while ((len = inputStream.read(buff)) != -1) {
                        baos.write(buff, 0, len);
                    }
                    System.out.println(baos.toString());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server() {
        try (ServerSocket ss = new ServerSocket(8899)) {
            try (Socket accept = ss.accept()) {
                try (InputStream inputStream = accept.getInputStream()) {
                    try (FileOutputStream fos = new FileOutputStream("output1.txt")) {
                        byte[] buff = new byte[10];
                        int len;
                        while ((len = inputStream.read(buff)) != -1) {
                            fos.write(buff, 0, len);
                        }
                    }
                    try (OutputStream outputStream = accept.getOutputStream()) {
                        outputStream.write("success".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
