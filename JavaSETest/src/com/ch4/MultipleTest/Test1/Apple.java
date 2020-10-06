package com.ch4.MultipleTest.Test1;

public class Apple extends SoftWare implements Phone,ReleaseTime {
    /*
    * 以下在类中，实现接口中的方法代码是错误的，因为接口中的方法是
    * public abstract 是默认的，所以在实现其方法时，必须要将其定义成，大于等于其权限的方法
    * 以后程序没有什么特殊需求，实现方法时就直接把它定义成为和接口方法一样的权限
    * void band() {//系统自动为其加上权限
        System.out.println("Iphone 6s 64GB");
        }
    * default void band() default权限比public低
    *
    *
    *
    * */
    public void band() {
        System.out.println("Iphone 6s 64GB");
    }

    public void money() {
        System.out.println("5000元");
    }

    public void country() {
        System.out.println("美国");
    }

    public void time() {
        System.out.println("ios 操作系统");
    }

    public void os() {
        System.out.println("2015年9月 全球发售");
    }
}
