package com.ch3.SingleState;

public class SingleStateTest {
    //测试单例模式
    /*
    * 单例模式示例：单例类的对象，在程序运行过程中最多只能有一个对象在运行
    * */
    //单例类
    //封装一个成员变量
    int a=8;
    private static SingleStateTest ss=new SingleStateTest();

    //自定义构造器，并且加权限，限制类外部随意访问
    private SingleStateTest() {

    }

    //定义一个方法，返回ss单例对象的引用

    /*
    * 让类的外部访问返回单例对象的方法，此时必须通过类名直接访问
    * */
    public static SingleStateTest getInstance() {
        return ss;
    }

}
