package com.ch4.SuperTest;

public class MainSuperTest2 {
    public static void main(String [] args) {
        //实例化子类对象
        ChildClass2 cc1=new ChildClass2(2,3,4);
        ChildClass2 cc2=new ChildClass2(2,3);
        /*
        * 使用此句实例化对象cc2时，不会输出 子类中有三个参构造方法 因为实例化对象cc2时
        * 只给它赋了2个值，所以它不会去调用三个参的构造方法，而是只去调用两个参数的构造方法
        *
        * */

        cc1.fun2();
        cc1.fun1();
    }
}
