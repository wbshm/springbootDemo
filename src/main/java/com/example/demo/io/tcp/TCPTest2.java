package com.example.demo.io.tcp;

import com.example.demo.io.Config;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPTest2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 18:03
 */
public class TCPTest2 {
    /**
     * 客户端发送消息给服务端
     */
    @Test
    public void client() throws IOException {
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        try (Socket socket = new Socket(inet, 8899)) {
            try (OutputStream os = socket.getOutputStream()) {
                try (FileInputStream fis = new FileInputStream(Config.inputPath)) {
                    byte[] buff = new byte[5];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        os.write(buff, 0, len);
                    }
                }
            }
        }
    }

    @Test
    public void server() {
        try (ServerSocket socket = new ServerSocket(8899)) {
            try (Socket accept = socket.accept()) {
                try (FileOutputStream fos = new FileOutputStream("input2.txt")) {
                    InputStream is = accept.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[5];
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                    }
                    fos.write(baos.toByteArray());
                    System.out.println("success");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
