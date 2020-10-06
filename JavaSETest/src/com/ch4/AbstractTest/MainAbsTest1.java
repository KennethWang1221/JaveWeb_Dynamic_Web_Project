package com.ch4.AbstractTest;

public class MainAbsTest1 {

    public static void main(String[] args) {
        //对抽象类实例化对象，观察特点 ***抽象类不能直接实例化
        //AbstractTestClass1 ab1=new AbstractTestClass1();
        SoftStudent st1=new SoftStudent();
        st1.tingke();

        ArtStudent at1=new ArtStudent();
        at1.tingke();
    }
}
