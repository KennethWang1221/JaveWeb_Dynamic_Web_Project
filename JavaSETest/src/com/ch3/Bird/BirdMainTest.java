package com.ch3.Bird;

public class BirdMainTest {
    /*
     * Java的程序直接在Windows上运行的，乘坐application
     * 它的标志是有main方法，包含main方法的类，称作主类
     * */
    public static void main(String[] args) {

        /*
         * 类就像某件产品设计时的图纸，不能直接使用程序运行时需要使用"产品"，称作对象。
         * 对象需要实例化，或者称作创建
         *
         * 运行时需要真实的对象，所以要进行实例化
         * 以某个类名为名称的类型，称作引用类型。本质就是指针
         * 但是在Java中将它进行了封装，做了限制，所以改名称作引用
         * */

        BirdDefine bd1 = new BirdDefine();
        bd1.setType("麻雀");
        bd1.setAge(2);

        //再创建一个对象
        BirdDefine bd2;
        bd2 = new BirdDefine();
        bd2.setType("鸽子");
        bd2.setAge(5);

        bd1.fly();
        bd2.fly();

        bd1.eat();
        bd2.eat();

        //测试静态变量的范围
        System.out.println("class num=" + bd1.num);

        bd1.num = 19;
        System.out.println("class num=" + bd2.num);
        System.out.println("class num=" + BirdDefine.num);
    }
}
