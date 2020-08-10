package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StackOverflowErrorDemo2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/7 11:17
 */
public class StackOverflowErrorDemo2 {
    public static void main(String[] args) {
        Dept d = new Dept("Market");
        Emp e = new Emp("emp1");
        e.setDept(d);
        Emp e2 = new Emp("emp2");
        e2.setDept(d);
        d.setEmps(Arrays.asList(e, e2));

        System.out.println(d);

        int[] a = new int[10];

    }
}

class Emp {
    Dept dept;
    String name;

    public Emp(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", name='" + name + '\'' +
                '}';
    }
}

class Dept {
    String name;

    public Dept(String name) {
        this.name = name;
    }

    List<Emp> emps = new ArrayList<>();

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
