package com.ch4.ObjectTest.CatEqualsTest;

public class MainCatEquals {

    /*
    * object类中的方法，基本上子类需要使用时，要重写，才能根据程序的需要，完成功能。
    *
    * 对于对象的相等判断，怎样进行？
    * 1，比较对象，标准谁定？需要根据程序需要而定
    * 2，标准有了，该怎么办？重写object类的equals方法
    *
    * */
    public static void main(String[] args) {
        //判断两只猫对象，是否相等
        //创建两只猫对象

        Cat cat1=new Cat(3,"白色","波斯猫");
        Cat cat2=new Cat(3,"白色","波斯猫");

        if(cat1==cat2) {
            //判断变量的地址，肯定不同
        }

        //使用equals 方法判断
        if(cat1.equals(cat2)) {
            System.out.println("两只猫一样");
        }else {
            System.out.println("两只猫不一样");
        }
    }
}
