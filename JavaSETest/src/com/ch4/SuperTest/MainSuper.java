package com.ch4.SuperTest;

public class MainSuper {
    public static void main(String[] args) {
        //实例化子类对象
        ChildClass1 cc1=new ChildClass1(1);
        System.out.println("================");
        ChildClass1 cc2=new ChildClass1();
        cc1.intro();
        cc1.fun1();
        cc1.fun2();
    }
}
