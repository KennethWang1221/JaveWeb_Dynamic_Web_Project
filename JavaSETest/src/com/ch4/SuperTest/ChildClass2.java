package com.ch4.SuperTest;

public class ChildClass2 extends SuperTest2{

    int c=99;
    /*
    * 子类无参的构造器，必须先能调用父类无参构造器，才能实例化
    * 由于父类中无参构造器不提供了，现在就需要在子类中定义构造器
    * 并且访问父类中的有参构造器。
    *
    * */

    public ChildClass2() {
        super();
        System.out.println("子类中的无参构造方法");
    }

    public ChildClass2(int m,int n) {
        //如何调用父类构造器？
        super(m,n);
        System.out.println("子类中的有两个参数构造方法");

        /*
        * super（m,n）;这句是指定调用父类的某个构造器，针对此例来说，就是调用
        * 父类中的两个参数的构造器，
        * 如果把它注释掉，那么现在就没有指定了，那么实例化对象时，调用此构造器，也会调用
        * 父类中的构造器，就会自动调用父类中的无参的构造方法
        *
        *
        * 正在创建的子类对象，必须先创建我的父类对象并包含，
        * super可以找到正在包含的父类对象
        *
        * this和super访问构造器时，都必须是第一行，因此不能同时出现
        * */

    }

    public ChildClass2(int m,int n,int c) {
        //super();
        //this(m,n);
        this.m=m;
        this.n=n;
        this.c=c;
        System.out.println("子类中的三参构造方法");
    }

    public void fun2() {
        //以下两句相同
        System.out.println("chilid class m="+this.m+" n= "+this.n+"c="+this.c);
    }
}
