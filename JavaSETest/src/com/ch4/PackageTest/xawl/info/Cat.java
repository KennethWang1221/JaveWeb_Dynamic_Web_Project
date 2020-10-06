package com.ch4.PackageTest.xawl.info;

/*
* 在带包名的cat类中，访问带包名的Bird类
*
* */


import com.ch4.PackageTest.edu.xawl.Bird;

public class Cat {
    int age=3;
    String name="花猫";

    public void fun2() {
        System.out.println("花猫懒洋洋的");
    }

    //main方法中，需要访问Bird类的对象
    public static void main(String[] args) {
        Bird bd1=new Bird();
        bd1.fun1();

        Cat ca1=new Cat();
        ca1.fun2();
    }
}
