package com.example.demo.io.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 *
 * @ClassName TCPTest1
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 17:34
 */
public class TCPTest1 {


    /**
     * 客户端发送消息给服务端
     */
    @Test
    public void client() throws IOException {
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        try (Socket socket = new Socket(inet, 8899)) {
            try (OutputStream os = socket.getOutputStream()) {
                os.write("你好，我是客户端mm".getBytes());
            }
        }
    }

    @Test
    public void server() {
        try (ServerSocket socket = new ServerSocket(8899)) {
            try (Socket accept = socket.accept()) {
                InputStream is = accept.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[5];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.err.println(socket.getInetAddress().getHostAddress());
                System.out.println(baos.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
