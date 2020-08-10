package com.example.demo.ioc;

import com.example.demo.ioc.anotation.MyAutowired;
import com.example.demo.ioc.anotation.MyComponent;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MyApplicationContext
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/10 11:20
 */
public class MyApplicationContext {

    /**
     * 存储实例后的Bean容器
     */
    private final Map<String, Object> beanMap = new ConcurrentHashMap<>();
    /**
     * 需要实例化的对象Class全路径名
     */
    private final Set<String> classNameSet = new HashSet<>();

    public MyApplicationContext() {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化IOC容器
     *
     * @throws Exception
     */
    public void init() throws Exception {
        //1、定位资源
        String beanScanPath = getBeanScanPath("ioc.bean.scan");
        //2、加载需要实例化的Class
        loadBeanClass(beanScanPath);
        //3、实例化bean
        registerBean();
        //4、注入bean的属性
        dependenceInjection();

    }

    /**
     * 根据Bean名称获取对象实例
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return beanMap.get(name);
    }

    /**
     * 定位需要进行实例化JAVA类
     * @param key 文件路径
     */
    private String getBeanScanPath(String key) {
        Properties properties = IocUtil.getPropertyByName("my-ioc.properties");
        return properties.get(key).toString();

    }

    /**
     * 加载JAVAClass
     */
    private void loadBeanClass(String packageName) {
        String filePath = packageName.replace(".", "/");
        URL url = this.getClass().getClassLoader().getResource(filePath);
        //得到根文件夹
        assert url != null;
        File rootFile = new File(url.getFile());
        //遍历所有文件夹
        for (File file : Objects.requireNonNull(rootFile.listFiles())) {
            if (file.isDirectory()) {
                //文件夹则递归
                loadBeanClass(packageName + "." + file.getName());
            } else {
                if (file.getName().indexOf(".class") > 0) {
                    //保存class类
                    classNameSet.add(packageName + "." + file.getName().replace(".class", ""));
                }
            }
        }
    }

    /**
     * 注册实例化Bean
     */
    private void registerBean() throws Exception {
        if (classNameSet.size() > 0) {
            for (String className : classNameSet) {
                //实例化对象放入beanMap
                Class<?> clazz = Class.forName(className);
                MyComponent myComponent = clazz.getAnnotation(MyComponent.class);
                if (myComponent == null) {
                    continue;
                }
                //定义bean key名称
                String beanName = (StringUtils.isEmpty(myComponent.value())) ? IocUtil.toLowercaseIndex(clazz.getSimpleName()) : myComponent.value();
                beanMap.put(beanName, clazz.newInstance());
            }
        }
    }


    /**
     * 依赖注入
     */
    private void dependenceInjection() throws Exception {
        if (beanMap.size() == 0) {
            return;
        }
        for (Object o : beanMap.values()) {
            doInjection(o);
        }
    }


    private void doInjection(Object o) throws Exception {
        //获取类的属性，进行依赖注入
        Field[] fields = o.getClass().getDeclaredFields();
        if (fields.length > 0) {
            for (Field file : fields) {
                MyAutowired autowired = file.getAnnotation(MyAutowired.class);
                if (autowired != null) {
                    //得到beanName 验证该Bean是否已经实例化了
                    String beanName = (StringUtils.isEmpty(autowired.value())) ? IocUtil.toLowercaseIndex(file.getType().getSimpleName()) : autowired.value();
                    //如果bean已经被实例化了,否则创建对象
                    if (!beanMap.containsKey(beanName)) {
                        Class clazz = file.getType();
                        beanMap.put(beanName, clazz.newInstance());
                    }
                    //调用对象set方法注入属性
                    file.setAccessible(true);
                    file.set(o, beanMap.get(beanName));
                    //递归当前实例化的对象的属性注入
                    doInjection(beanMap.get(beanName));
                }

            }
        }

    }
}
