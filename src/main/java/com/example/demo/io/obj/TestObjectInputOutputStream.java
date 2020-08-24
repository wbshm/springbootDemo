package com.example.demo.io.obj;

import com.example.demo.io.Config;
import org.junit.Test;

import java.io.*;

/**
 * @ClassName testObjectInputOutputStream
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 16:09
 */
public class TestObjectInputOutputStream {

    @Test
    public void testObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Config.inputPath));
        String str = "测试测试";
        oos.writeObject(str);
        oos.flush();
        oos.writeObject(new Person("你好", 12));
        oos.flush();
        oos.close();
    }


    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(Config.inputPath));
            Object obj = ois.readObject();
            String str = (String) obj;
            Person person = (Person) ois.readObject();
            System.out.println(person);
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
