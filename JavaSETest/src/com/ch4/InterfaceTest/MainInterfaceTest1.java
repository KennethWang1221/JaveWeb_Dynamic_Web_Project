package com.ch4.InterfaceTest;

public class MainInterfaceTest1 {
    public static void main(String[] args) {
        /*
        * 抽象类不能实例化，接口更不能
        * */

        System.out.println(CarTools.speed);

        MircoCar mc=new MircoCar();
        mc.start();
        mc.drive();
        mc.stop();

        System.out.println("===============");

        MountainCar mo=new MountainCar();
        mo.start();
        mo.drive();
        mo.stop();
        mo.sport();

    }
}
