package com.example.demo.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName GetChannel
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 14:43
 */
public class GetChannel {
    private static final int BSIZE = 1 << 10;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\read.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\read.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\read.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
}
