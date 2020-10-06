package com.ch4.ObjectTest.ObjectTest2;

public class ObjectTest2 {
    public static void main(String[] args){
        Object ob1=new Object();
        System.out.println(ob1);
        java.util.Date md=new java.util.Date();
        System.out.println(md.getClass());


        Dog2 dg2=new Dog2();
        //输出对象的变量时
        /*
        * java 中直接输出某个对象的变量时，默认输出的信息是类名 @hashcode
        * 不足以表示对象的特征。这种输出对象变量的信息内容，是由该对象的toString方法决定。
        * 如果类中没有重写toString方法，则运行继承到的
        * 问题：现在输出dg2变量时，为什么object的toString方法还能管到这里来？
        *     任何类型都是object的子类，或者直接，或者间接。
        *     如果自定义的类对继承到的toString方法不满意，自己重写
        *
        *
        *
        *
        * */
        System.out.println(dg2);
        java.util.Date md2=new java.util.Date();
        System.out.println(Integer.toHexString(md.hashCode()));

        //对于有的类，hashCode就不能达到查看内存地址哈希值的目的
        String str2=new String("book");
        String str3=new String("book");

        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));

        System.out.println(str2==str3);
        System.out.println(str2.equals(str3));
        System.out.println(str2.toString());


    }
}
