package com.example.demo.io.obj;

import java.io.Serializable;

/**e
 * @ClassName Person
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/22 16:14
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 123L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
