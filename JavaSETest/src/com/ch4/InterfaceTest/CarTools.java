package com.ch4.InterfaceTest;

public interface CarTools {
    /*
    * 复习抽象类。
    * 如果一个类里面的所有方法都是抽象方法，类抽象到极端了
    * 称作抽象类不足以表示其特殊和抽象，就需要另叫名字：接口
    * 关键字 ：interface
    * 既然已经另起名字，表示其特殊性了，也就是所有方法肯定全部抽象
    *
    * **接口中的方法，全部默认就是  abstract public
    * 接口中也可以设计"量"，，默认就是public static final
    *
    * */


    /*
    * java 接口的作用和特点
    *
    * 1.接口的本质
    * 思考：DIY 台式电脑时，主板，cup，内存，硬盘，显卡，电脑的主要部件，
    * 都是在主板的相应插槽中连接。主板的插槽又称作接口，这些接口都有相应的设计标准
    * 比如，硬盘的SATA接口，内存的DDR3接口，是不是先要买好硬盘和内存，
    * 才能去选主板？
    *
    * 理解：硬件应用中的接口，只要符合设计标准，连接的设备随便接都可以用，USB接口，不可能只能连接
    * u盘，只要符合USB电路规范的设备，都可以连。
    * **************
    *软件设计中，能不能也有这样的设计思路
    * Java中，就设计了接口的方式实现
    * */
    int speed =6;
    /*public static final*/ int age=3;
    //下句前边这 是多余的
    //public static final int age=3;
    /*
    * 车辆工具类，约束他的功能，符合这些功能类，才能算此类
    * */

    //每种车，启动的方式不一样，只能规定必须能启动
    //在接口中写abstract public 是多余的
    /*abstract public void start();
    //驾驶功能
    abstract public void deive();
    //刹车
    abstract public void stop();*/
    void start();
    void drive();
    void stop();



}
