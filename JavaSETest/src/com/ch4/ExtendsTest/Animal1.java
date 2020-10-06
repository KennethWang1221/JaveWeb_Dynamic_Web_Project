package com.ch4.ExtendsTest;

public class Animal1 {
    /*
    * 了解Java的基础机制
    * */

    //定义父类，也称作基类，或者超类
    //封装变量
    int age;
    String name;
    String type;


    public Animal1() {
        //定义一个无参的构造器，否则报错
        System.out.println("父类中无参构造方法");
    }

    public Animal1(String type,int age) {
        System.out.println("父类中两参构造方法");
        this.type=type;
        this.age=age;
    }

    //为name 赋值的方法
    public void setName(String name) {
        this.name=name;
    }

    //封装方法
    public void shout() {
        System.out.println("动物一般都会发出声音");
    }

    //测试方法重写的返回类型
    public A22 fun2() {
        return new A22();
    }

}
