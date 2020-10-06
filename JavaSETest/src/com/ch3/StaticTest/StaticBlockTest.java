package com.ch3.StaticTest;

public class StaticBlockTest {
    static int age;
    static float weight;
    //静态代码块

    static {
        age=5;
        weight=5.6f;
        System.out.println("静态代码块运行了一次");
    }

    public static void main(String[] args) {
        StaticBlockTest sbt1=new StaticBlockTest();
        StaticBlockTest sbt2=new StaticBlockTest();
        StaticBlockTest sbt3=new StaticBlockTest();
    }
}
