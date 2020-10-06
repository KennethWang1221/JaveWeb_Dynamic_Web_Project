package com.ch4.SuperTest;

public class SuperTest2 {
    /*
    * super 调用父类的构造器示例
    *
    * */
    int m,n;

    public SuperTest2() {
        System.out.println("父类中的无参构造方法");
    }

    //自定义父类的有参构造方法
    public SuperTest2(int m,int b) {
        System.out.println("父类中的有参构造方法");
    }

    public void fun1() {
        System.out.println("supper class m="+this.m+"n="+this.n);
    }

}
