package com.ch4.FinalTest;

public class ChildFinalTest2 extends FinalTest2 {

    int mmm=999;

    // 对父类的fun1方法重写,是不允许的会报错，因为final修饰的方法不能被子类重写
    /*public void fun1() {
        System.out.pritnln("child class print mmm="+mmm);
    }*/
}
