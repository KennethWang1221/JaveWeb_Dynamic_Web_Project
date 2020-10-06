package com.ch4.AbstractTest;

public class SoftStudent extends AbstractTestClass1 {
    /*
    * 抽象类不能直接实例化使用，必须派生子类
    * */


    //对父类的抽象方法，重写（覆盖）
    public void tingke() {
        System.out.println("软件专业的学生需要机房环境听课。");
    }

}
