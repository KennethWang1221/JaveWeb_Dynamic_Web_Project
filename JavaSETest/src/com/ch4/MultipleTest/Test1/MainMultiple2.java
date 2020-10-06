package com.ch4.MultipleTest.Test1;

/*public class MainMultiple2 {

    public  static void getos(SoftWare2 sw) {
        sw.os();
    }

    public void getPhone(Phone2 p2){
        p2.band();
        p2.country();
        p2.money();
    }

    *//*public void getband(Phone2 p2) {
        p2.band();
    }

    public void getcountry(Phone2 p2) {
        p2.country();
    }

    public void getmoney(Phone2 p2) {
        p2.money();
    }*//*

    public void getrelease(ReleaseTime2 re2) {
        re2.release();
    }


    public static void main(String[] args) {
        MainMultiple2 mm=new MainMultiple2();

        //实现apple类的多态
        SoftWare2 sw2=new Apple2();
        Phone2 p2=new Apple2();
        ReleaseTime2 re2=new Apple2();

        MainMultiple2.getos(sw2);
        *//*mm.getband(p2);
        mm.getcountry(p2);
        mm.getmoney(p2);*//*
        mm.getPhone(p2);
        mm.getrelease(re2);


        //实现HuaWei 类的多态
        SoftWare2 hw=new HuaWei2();
        Phone2 hw2=new HuaWei2();
        ReleaseTime2 hw3=new HuaWei2();

        //mm.getos(hw);
        MainMultiple2.getos(hw);
        *//*mm.getband(hw2);
        mm.getcountry(hw2);
        mm.getmoney(hw2);*//*
        mm.getPhone(hw2);
        mm.getrelease(hw3);

    }
}*/


public class MainMultiple2 {
    public void getos2(SoftWare2 sw2) {
        sw2.os();
    }

    public void getPhone2(Phone2 ph2) {
        ph2.money();
        ph2.country();
        ph2.band();
    }

    public void getRelease2(ReleaseTime2 re2) {
        re2.release();
    }


    public static void main(String[] args) {
        MainMultiple2 mm2=new MainMultiple2();


        //实现apple类的多态
        Phone2 p2=new Apple2();
        ReleaseTime2 re2=new Apple2();
        SoftWare2 sw2=new Apple2();

        //sw2.os();
        sw2.os2();

        mm2.getos2(sw2);
        mm2.getRelease2(re2);
        mm2.getPhone2(p2);


        //实现HuaWei
        Phone2 p3=new HuaWei2();
        ReleaseTime2 re3=new HuaWei2();
        SoftWare2 sw3=new HuaWei2();

        mm2.getos2(sw3);
        mm2.getPhone2(p3);
        mm2.getRelease2(re3);



    }
}



















