package com.ch4.ExtendsTest;

public class MainExtendsTest1 /*extends Object*/ {
    public static void main(String[] args) {
        //实例化子类对象
        Tiger tg1=new Tiger("虎科",22);

        //实例化一个子类对象
        //Tiger tg1=new Tiger();
        //实例化一个父类对象
        Animal1 an1=new Animal1();
        an1.shout();//父类对象的调用

        //访问继承的父类的继承方法(自己根据自己情况进行了重写)
        tg1.setName("老虎大可爱");
        tg1.shout();//子类对象的调用

        //访问子类的自定义的方法
        tg1.setMoney(5);
        tg1.exhibition();
        tg1.intro();
        tg1.fun2();


    }

}
