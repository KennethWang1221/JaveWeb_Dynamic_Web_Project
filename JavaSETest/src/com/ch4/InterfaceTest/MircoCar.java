package com.ch4.InterfaceTest;

public class MircoCar implements CarTools {
    /*
    * 接口无法直接实例化
    * 需要设计子类，实现接口，此时有两条路可以走
    * 1.将实现的接口中所有抽象方法全部重写，才能实例化
    * 2.如果接口中的抽象方法没有全部重写，则需要在class前面加上abstract（不推荐因为这是缓兵之计，后患无穷）
    * */

    //重写所有抽象方法
    public void start() {
        System.out.println("微型汽车用电瓶车启动");
    }
    public void drive() {
        System.out.println("微型汽车需要驾驶证");
    }
    public void stop() {
        System.out.println("微型汽车用紧急制动器刹车");
    }
}
