package com.ch3.InnerClassTest;

public class MainInnerTest2 {
    public static void main(String[] args) {
        OuterClass2 ot1=new OuterClass2();
        OuterClass2.InnerClass1 in1=ot1.new InnerClass1();
        in1.inClass1Method();

        //引用静态内部类时，直接使用类名调用
        OuterClass2 ot2=new OuterClass2();
        OuterClass2.InnerClass2 in2=new OuterClass2.InnerClass2();
        in2.inClass2Method();
        //对象不能直接调用静态内部类中的静态方法，要使用类名调用
        //in2.inClass2Method2();
        OuterClass2.InnerClass2.inClass2Method2();

        //测试方法内部类
        OuterClass2 ot3=new OuterClass2();
        ot3.OuterMethod();
        ot3.OuterMethod2();
    }
}
