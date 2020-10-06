package com.ch4.MultipleTest;

public class MultiStateTest1 {

    /*
    * 多态：声明为父类的引用变量，在运行时可以任意指向其子类对象，并且调用重写方法时
    * 可以实现是什么对象，运行什么功能。
    *
    * */

    //需要一只动物的方法，未将其定义成静态方法，
    // 也就是将其定义成非静态方法

    public void getAnimal(Animal3 an) {
        //想听动物叫声
        an.shout();
    }

    /*public static void getAnimal(Animal3 an) {
        //想听动物叫声
        an.shout();
    }*/

    public static void main(String[] args) {
        MultiStateTest1 ms=new MultiStateTest1();
        //创建动物，传给方法
        Animal3 an= new Animal3();
        Animal3 an2=new Dog();//创建Dog对象，使用Animal类型的变量an2引用
        Animal3 an3=new Cat();

        /*
        * 以下三句是使用 静态方法时可以使用 类名.方法名 调用(前提是调用的方法必须是经过static修饰过的)
        * 就是静态方法，当然也可以使用 类的实例化对象进行调用
        * */



        /*MultiStateTest1.getAnimal(an);
        MultiStateTest1.getAnimal(an2);
        MultiStateTest1.getAnimal(an3);
        getAnimal(an);=MultiStateTest1.getAnimal(an); 这两个相等
        getAnimal(an2);
        getAnimal(an3);


        */


        ms.getAnimal(an);
        ms.getAnimal(an2);
        ms.getAnimal(an3);
    }
}
