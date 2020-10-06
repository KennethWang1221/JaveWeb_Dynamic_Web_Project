package com.ch3.InnerClassTest;

public class MainInnerTest1 {
    public static void main(String[] args) {
        //实例化外部类对象
        OuterClass1 ot1=new OuterClass1();
        //实例化内部类对象
        //InnerClass1 in1=null;
        /*
        * 成员内部类实例化时需要一个外部类对象，并且用该对象调用new
        * */

        //以下两种方法都可以正常输出！
        //OuterClass1.InnerClass1 in2=ot1.new InnerClass1();

        OuterClass1.InnerClass1 in2=ot1.new InnerClass1();
        in2.innerFun1();
        ot1.OuterFun2();

        //静态内部类的实例化
        OuterClass1.InnerClass3 in5=null;
        in5=new OuterClass1.InnerClass3();
        in5.innerFun3();

    }
}


















