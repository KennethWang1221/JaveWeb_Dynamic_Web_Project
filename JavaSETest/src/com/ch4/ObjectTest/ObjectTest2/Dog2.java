package com.ch4.ObjectTest.ObjectTest2;

public class Dog2 extends Object  {

    /*
    * object 类，是Java的根类型，Java中的类，
    * 不管直接或者间接都继承了object
    *
    *
    * */
    int age=8;
    String color="黑色";
    String type="德国黑贝";
    //方法
    public void intro(){
        System.out.println(this.type+"颜色"+color+"年龄"+age);
    }

    //重写Object中的toString方法
    public String toString(){
        //输出一只狗对象变量，应该显示什么信息？ 自己决定
        System.out.println("类型："+this.type+"颜色："+color+"年龄："+age);
        String str="类型："+this.type+"颜色"+color+"年龄："+age;
        return str;
    }
}
