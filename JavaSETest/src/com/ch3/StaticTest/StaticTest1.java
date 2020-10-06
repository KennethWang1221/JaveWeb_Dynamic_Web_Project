package com.ch3.StaticTest;

public class StaticTest1 {
    /*
    * 类中只能出现结构定义的语句，不能出现功能执行语句
    * （因为功能执行语句必须要开辟内存空间才行，类中结构定义只是定义，定义不会给其开辟空间
    * 所以报错）
    * 功能执行语句，需要写在方法中（等之后new了一个对象（
    * new对象就等于开辟了一个内存空间，把这个空间起了个别名叫你刚刚new的那个名字）去调用这个方法）
    * 类中定义变量时，前面加上static关键字，称作静态变量
    *
    * */
    int age;
    String name;
    static int num=2;

    //定义对象方法，能否访问静态的变量
    public void fun1() {
        num=34;
        System.out.print("fun1 方法中的语句输出static num="+num);
    }


    //定义方法类，类方法中能否访问对象资源---answer:不能
    /*public static void fun2() {
        age=5;
        System.out.println("静态方法调用，age="+age);
    }*/

    public static void fun3() {

        System.out.println("StaticTest1中的 static method");
    }



}
