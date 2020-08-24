package com.example.demo.io;

import java.io.*;

/**
 * @ClassName OSExcute
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/21 14:30
 */
public class OSExcute {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\OSExcute.java"));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("D:\\project\\javaWorkSpace\\javaDemo\\src\\main\\java\\com\\example\\demo\\io\\out.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }

}
