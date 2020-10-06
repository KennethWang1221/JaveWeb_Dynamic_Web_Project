package com.ch4.ObjectTest.CatEqualsTest;

public class Cat {
    int age;
    String color;
    String type;

    //定义构造方法
    public Cat() {

    }

    public Cat(int age,String color,String type) {
        this.age=age;
        this.color=color;
        this.type=type;
    }

    //方法

    public void eat() {

    }

    //重写equals 方法
    public boolean equals(Object obj) {
        /*
        * 现在需要比较的对象是 cat， 而形参是object ，需要进行将object
        * 对象下转型为某个子类，这里是cat的对象
        *
        *
        * */

        Cat cat=null;
        if(obj instanceof Cat) {
            cat= (Cat) obj;
        }else {
            return false;

        }

        if(this.age==cat.age && this.color.equals(cat.color)
                && this.type.equals(cat.type)) {
            return true;
        }else{
            return false;
        }
    }



}
