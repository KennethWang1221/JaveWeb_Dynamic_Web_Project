package com.ch4.PackageTest.com.zhangsan;


//解决类名有可能的冲突问题，需要加上名称限定
public class Animal {
    /*
    * 张三开发的表示动物的类
    * */
    int age=3;
    String name="老虎";
    public void fun1() {
        System.out.println("张三设计的动物类s");
    }

    public static void main(String[] args) {
        new Animal().fun1();
    }
}
