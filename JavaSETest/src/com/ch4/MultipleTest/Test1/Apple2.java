package com.ch4.MultipleTest.Test1;

/*public class Apple2 extends SoftWare2 implements Phone2,ReleaseTime2 {

    public void os() {
        System.out.println("iOS 操作系统");
    }

    public void band() {
        System.out.println("苹果6s");
    }

    public void money() {
        System.out.println("5500元");
    }

    public void country() {
        System.out.println("美国");
    }

    public void release(){
        System.out.println("2015年9月份");
    }


}*/


public class Apple2 extends SoftWare2 implements Phone2,ReleaseTime2 {
    @Override
    public void band() {
        System.out.println("苹果手机");

    }

    @Override
    public void money() {
        System.out.println("5000元");

    }

    @Override
    public void country() {
        System.out.println("美国");

    }

    @Override
    public void release() {
        System.out.println("15年年初");

    }

    public void os() {
        System.out.println("ios 操作系统");
    }
}
