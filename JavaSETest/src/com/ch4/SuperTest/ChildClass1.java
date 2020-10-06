package com.ch4.SuperTest;

public class ChildClass1 extends SuperTest1 {
    //定义同名的变量 age

    int age=88;

    //自定义构造器
    public ChildClass1 () {
        super();
        System.out.println("子类的无参构造器");
    }

    public ChildClass1 (int a) {
        super(2);
        System.out.println("子类的有参构造器");

    }
    //重写的成员方法
    public void intro() {
        //以下两句都对，输出结果相同都是ChildClass1本类中的age age=88;
        //System.out.println("ChildClass1 age="+age);
        System.out.println("ChildClass1 age="+this.age);
    }

    //对象方法
    public void fun1() {
        System.out.println("fun1() age="+this.age);

        //访问父类中继承到的同名变量
        System.out.println("fun1() superClass age="+super.age);
    }

    //定义方法，使用super访问父类中被重写的方法
    public void fun2() {
        super.intro();
    }

}
