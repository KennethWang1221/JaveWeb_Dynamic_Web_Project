package com.ch4.MultipleTest.Test2;

public class ChildClassCast1 extends ClassCastTest1 {
    //增加属性
    String name="abc";

    //重写父类的普通方法

    @Override
    public void fun1() {
        super.fun1();
        System.out.println("child class fun1()...重写的父类方法");
    }

    //子类增加的方法
    public void fun2() {
        System.out.println("child的子类增加方法");
    }

    public static void main(String[] args) {
        //main方法就像一个运行程序的启动客户端
        ClassCastTest1 superObj1=new ClassCastTest1();
        ChildClassCast1 childObj1=new ChildClassCast1();

        //将子类对象，赋值给父类的引用变量。
        superObj1=childObj1;
        superObj1.fun1();

        //使用上转型的对象，访问子类增加的方法
        /*
        * 由于父类中没有定义fun2（）方法，而superObj1引用变量是父类的类型，
        * 下面语句在编译时类型检查过不去
        *
        * p131只能是父类中定义过的方法，若是子类中新增的方法，编译器会报错
        * （因为虽然对象实质是子类对象，但编译器看到声明是父类，
        * 会去父类中寻找方法名，找不到所以会报错）
        *
        * */
        //superObj1.fun2();

        /*
        * 上面的类型检查编译错误，会提示，父类中没有定义fun2方法，但是现在
        * superObj1变量命名指向的是一个子类对象，程序猿很清楚，该对象是能访问
        * fun2（）方法的，此时可以针对对象，使用强制类型转换。
        *
        * */

        ((ChildClassCast1) superObj1).fun2();

        /*
        * 对象的强制类型转换，必须注意"该对象能够被转换"，也就是真正是哪种类型，可以进行转换。
        *将父类的对象，强制转换为子类对象，称作对象的下转型
        *
        * 针对上转型而言，下转型不安全，上转型一般是安全的
        * 就像：能说老虎是动物，反之不能说动物就是老虎。
        * 下转型的应用前提：真正是一只老虎，但是带的帽子写的是动物此时可以把帽子换成老虎
        * */

        //将上面的强制类型转换，换个写法
        ChildClassCast1 child2=(ChildClassCast1)superObj1;

        //一个运算符，专门判断一个对象，是不是某个类型的对象
        boolean bo1=superObj1 instanceof ChildClassCast1;
        System.out.println(bo1);

        boolean bo2=superObj1 instanceof ClassCastTest1;
        System.out.println(bo2);

        //创建父类对象，判断父类对象，是不是属于某个子类类型

        ClassCastTest1 super2=new ClassCastTest1();
        boolean bo3=super2 instanceof ChildClassCast1;
        System.out.println(bo3);
    }
}
