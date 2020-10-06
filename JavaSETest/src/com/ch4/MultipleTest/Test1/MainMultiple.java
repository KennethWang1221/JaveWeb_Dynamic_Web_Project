package com.ch4.MultipleTest.Test1;

public class MainMultiple {
    /*
    * 以下主类及主方法代码中，实现多态，实现接口中的方法时，将其都定义成为非静态方法
    * 在类中 要想使用非静态方法，必须创建本类的对象，然后使用这个对象（对象，方法名）进行调用
    *
    *
    * */

    /*
    *class MianMultiple extends software implements phone ,releasetime
    * 若主类写成上句，继承了一个普通类和两个接口
    * 然而又没有在这个类中，重写实现所有接口类中的所有方法，
    * 程序就会报错（详情见，匿名类内部例子 anonymity2）
    *
    * */
    /*public void getos(SoftWare sw) {
        sw.os();
    }*/
    public static void getos(SoftWare sw) {
        sw.os();
    }

    public void getPhone(Phone p) {
        p.band();
        p.country();
        p.money();
    }
    /*public void getband(Phone p) {
        p.band();
    }

    public void getcountry(Phone p) {
        p.country();
    }

    public void getmoney(Phone p) {
        p.money();
    }*/

    public void getReleaseTime(ReleaseTime re) {
        re.time();
    }

    public static void main(String[] args) {
        MainMultiple mm= new MainMultiple();

        Phone p1=new Apple();
        ReleaseTime re=new Apple();
        SoftWare sw=new Apple();

        mm.getPhone(p1);
        /*mm.getband(p1);
        mm.getcountry(p1);
        mm.getmoney(p1)*/;
        mm.getReleaseTime(re);
        //mm.getos(sw);
        MainMultiple.getos(sw);


        System.out.println("==============");

        Phone p2=new HuaWei();
        ReleaseTime re2=new HuaWei();
        SoftWare sw2=new HuaWei();


        mm.getPhone(p2);
        /*mm.getband(p2);
        mm.getcountry(p2);
        mm.getmoney(p2);*/
        mm.getReleaseTime(re2);
        //mm.getos(sw2);
        MainMultiple.getos(sw2);

    }


}
