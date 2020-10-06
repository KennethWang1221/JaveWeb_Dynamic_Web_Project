package com.ch4.PackageTest.com.lisi;

/*
* 李四开发的用来表示动物习性的类
*
* */
public class Animal {
    /*
    * 在此类中不能用以下导包方式，因为Dongwu 中有Animal 主类，而要导入的animal中主类也是animal
    * 类，两者重复，编译 Javac -d . Dongwu.java时编译出错！
    * import com.zhangsan.Amimal
    * */

    String type="猫科动物";
    public void fun2() {
        System.out.println("李四设计的动物类");
    }


    public static void main(String[] args) {
        Animal an1=new Animal();
        an1.fun2();
        new Animal().fun2();


    }
}
