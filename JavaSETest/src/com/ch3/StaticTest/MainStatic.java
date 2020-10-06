package com.ch3.StaticTest;

public class MainStatic {



    public static void main(String[] args) {
        //静态变量又称作类变量，使用类名直接可以访问
        //System.out.println("类名访问：num="+StaticTest1.num);

        StaticTest1 st1=new StaticTest1();
        st1.num=8;
        System.out.println("对象访问：(重新定义过后的static num)num="+st1.num);
        System.out.println("类名访问：(重新定义过后的static num)num="+StaticTest1.num);


        //静态方法直接使用类名访问
        StaticTest1.fun3();
        //MainStatic.fun3();

        //使用对象能否访问静态方法？不能
        //st1.fun3();

        //使用对象能否访问非静态方法？当然可以
        st1.fun1();




    }

}
