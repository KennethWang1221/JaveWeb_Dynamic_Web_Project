package com.ch3.SingleState;

public class MainSingleTest {
    public static void main(String[] args) {
        /*
        * 要设计单示例的类，首先要避免在类的外部创建对象
        * 考虑创建对象的过程：new  构造方法，只能干预构造方法
        * 只要类的外部不能访问构造器，就无法创建对象了。
        * 在类的内部自定义private 权限的构造器，则类外部无法创建对象。
        * 由于还需要最多一个对象，满足使用，因此需要实例化一个对象
        * 构造方法此时只能在类的内部访问
        * */

        //不能用此方法创建对象，原因见上方注释
        //SingleStateTest ss1=new SingleStateTest();

        SingleStateTest ss1=SingleStateTest.getInstance();
        SingleStateTest ss2=SingleStateTest.getInstance();

        if(ss1==ss2) {
            System.out.println("ss1  ss2  是一个对象");
        }else {
            System.out.println("ss1  ss2  不是一个对象");
        }
    }
}

