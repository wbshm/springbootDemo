package com.example.demo.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @ClassName IocUtil
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 10:51
 */
public class IocUtil {
    /**
     * 根据filename查找对象
     * @param filename
     * @return
     */
    public static Properties getPropertyByName(String filename) {
        InputStream is = null;
        Properties pro;
        try {
            is = IocUtil.class.getClassLoader().getResourceAsStream(filename);
            pro = new Properties();
            pro.load(is);
            return pro;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            if (Objects.nonNull(is)) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String toLowercaseIndex(String name) {
        if (name != null && name.length() > 0) {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return null;
    }
}
