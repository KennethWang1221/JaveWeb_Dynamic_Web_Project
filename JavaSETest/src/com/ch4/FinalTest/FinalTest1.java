package com.ch4.FinalTest;

public class FinalTest1 {

    /*
    * 演示Java中final 关键字的使用 ，从三个方面解释
    * 修饰变量
    * 修饰方法
    * 修饰类
    * */
    //定义变量
    int m1;
    /*
    * final修饰的量，运行期间其值不能修改，所以定义的时候就要初始化
    * 也可以在允许的位置进行初始化(idea不行)
    *
    * */
    // final int m2; 左边错误写法
    final int m2;
    static final int m3=3;

    static{
        //对于类的final量，可以用静态代码块初始化，建议还是定义的时候就赋值
        int m4=4;
    }

    public FinalTest1() {
        m2=2;

    }

    //定义方法
    public void fun1() {
        //试图修改final量的值，final代表常量，不能修改值
        //m2=3;

    }


}
