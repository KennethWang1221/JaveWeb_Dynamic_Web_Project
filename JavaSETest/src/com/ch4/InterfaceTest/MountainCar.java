package com.ch4.InterfaceTest;


//一个类可以同时实现多个接口，用逗号隔开
public class MountainCar implements CarTools,SportTools {

    public void start() {
        System.out.println("山地车脚蹬启动");
    }

    public void drive() {
        System.out.println("山地车平衡形势");
    }

    public void stop() {
        System.out.println("山地车用碟刹制动");
    }


    public void sport() {
        System.out.println("可用于锻炼");
    }
}
