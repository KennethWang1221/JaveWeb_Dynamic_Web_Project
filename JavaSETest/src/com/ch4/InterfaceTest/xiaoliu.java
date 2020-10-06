package com.ch4.InterfaceTest;

public class xiaoliu implements Car {
    public void CarTool(){
        System.out.println("老板给小刘一辆自行车");

    }

    public void start() {
        System.out.println("小刘骑自行车去买票");
    }

    public void drive() {
        System.out.println("小刘一路骑着自行车");
    }

    public void stop() {
        System.out.println("小刘将自行车寄存在车棚");
    }
}
