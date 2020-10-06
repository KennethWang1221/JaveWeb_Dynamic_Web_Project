package com.ch4.InterfaceTest;

public class xiaozhang implements Car {

    public void CarTool() {
        System.out.println("老板给小张一辆汽车");

    }

    public void start() {
        System.out.println("小张开汽车去买票");

    }

    @Override
    public void drive() {
        System.out.println("小张一路飞镖汽车");

    }

    public void stop() {
        System.out.println("小张将汽车停放在停车场");

    }
}
