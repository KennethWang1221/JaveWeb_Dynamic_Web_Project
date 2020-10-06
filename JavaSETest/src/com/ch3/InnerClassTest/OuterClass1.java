package com.ch3.InnerClassTest;


public class OuterClass1 {

/*
    * 测试外部类和成员内部类的应用
    * */

    //成员变量
    int m=5;

    //私有变量
    private int mmm=888;

    //定义成员内部类
    class InnerClass1 {
        //内部类成员变量定义
        int n=8;
        //当内部类和外部类变量重名时的访问规则
        int m=900;

        //内部类成员方法
        public void innerFun1() {
            //定义局部变量m
            int m=680;
            System.out.println("inner value n="+n);
            System.out.println("inner value mmm="+mmm);

            /*
            * 分别访问三个重名的变量m  方法中的是局部变量！
            * 类中的是成员变量，也是对象变量！
            * 外部类中的是外部类中的成员变量
            * */

            System.out.println("局部变量 m="+m+"内部类对象变量 m="+this.m+" 外部类对象变量m="+OuterClass1.this.m);
        }
    }

    //定义静态内部类
    static class InnerClass3 {
        int x=99;
        public  void innerFun3() {
            System.out.println("static 内部类 x="+x);
        }
    }


    //外部类的对象方法
    public void outerFun1() {
        System.out.println("outer value m="+m);
    }

    //入口函数main

    //方法内部类
    public void OuterFun2() {
        //定义一个内部类
        class InnerClass2 {
            int a=88;
            public void innerFun2() {
                System.out.println("inner value a="+a);
            }
        }

        //最常见的是在本方法中实例化
        InnerClass2 in3=new InnerClass2();
        in3.innerFun2();
    }
}






















