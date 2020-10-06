package com.ch4.Annoymity;




/*
 * 匿名内部类（匿名类）
 * 是一种特殊的内部类，没有类名，直接使用其对象，仅仅使用一次。
 * 问题？ 这个没名字的类的对象，我们用他的什么？
 *   用的是该类对象中的某些功能，也就是调用方法。
 *   可以理解为，程序中只是关心被调用方法运行。
 *
 *   匿名内部类，一般都是配合抽象类或者接口来用
 *   因为如果是一个普通的类，则往往方法定义的是完备的，可以直接执行，这种情况，直接实例化，
 *   调用方法即可。
 *
 *   抽象类或接口，肯定有些方法没有具体实现，而且子类必须重写某些方法，才能使用。
 *   结合多态一起理解
 *
 * */
//需要"飞行器"类的对象工作的一个场合



public class FlyBiSaiXC {
    //飞行器比赛现场

    private String title="文理杯飞行器大赛";//广告语，每个飞行器必须挂上。

    class Plane extends Flyer{
        //重写抽象方法
        public void fly() {
            System.out.println("螺旋桨飞机航模飞的很平稳。");
        }
    }

    //方法，参赛
    public void bisai(Flyer f) {
        f.fly();


        /** 典型的多态应用，指向父类的变量f ，运行时可以任意指向某个子类对象，
        * 并且发挥该子类对象的飞行功能。
        *
        * */
    }

    public void canSai() {
        bisai(new Plane());
        bisai(new Flyer() {
            //重写方法
            public void fly() {
                System.out.println("这种航模很新颖，飞得又高又快。");
            }
        });

        //有一个飞行器比赛
        bisai(new Flyer(){

            //重写方法
            public void fly() {
                System.out.println("直升机就是好看，可以悬停。");
            }
        });
    }


    //主方法
    public static void main(String[] args) {
        FlyBiSaiXC xc=new FlyBiSaiXC();
        xc.canSai();
    }
}




















