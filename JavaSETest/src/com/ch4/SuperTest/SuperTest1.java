package com.ch4.SuperTest;

public class SuperTest1 {
    /*
    * super 关键字的使用
    *
    * 1.子类和父类成员变量同名时，子类中对同名变量的分别访问
    * */
    int age=6;
    String name=null;

    /*
     * 因为子类中定义了一个无参构造方法，而在实例化子类对象cc1时，肯定要一定会
     * 调用子类的无参构造方法，p87页构造方法概念
     * 现在子类继承了父类，所以子类中的构造方法也要去调用父类的构造方法，所以父类中必须要有一个
     * 无参的构造方法，否则程序报错！
     * */

    public SuperTest1() {
        System.out.println("父类的无参构造器");
    }

    //自定义有参构造器
    public SuperTest1(int age) {
        System.out.println("父类的有参构造器");
        this.age=age;
    }

    //对象方法
    public void intro() {
        System.out.println("SuperClass1 age="+this.age);
    }
}
