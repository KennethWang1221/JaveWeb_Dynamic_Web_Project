package com.ch4.MultipleTest.Test1;

/*public class HuaWei2 extends SoftWare2 implements Phone2,ReleaseTime2 {

    public void os() {
        System.out.println("android 操作系统");
    }

    public void band() {
        System.out.println("华为手机！");
    }

    public void country() {
        System.out.println("中国");
    }

    public void money() {
        System.out.println("5003");
    }

    public void release() {
        System.out.println("2015年 年初");
    }
}*/




public class HuaWei2 extends SoftWare2 implements Phone2,ReleaseTime2{
    @Override
    public void band() {
        System.out.println("华为手机");

    }

    @Override
    public void money() {
        System.out.println("3000元");

    }

    @Override
    public void country() {
        System.out.println("中国产的");

    }

    @Override
    public void release() {
        System.out.println("15年年末");

    }

    public void os() {
        System.out.println("android操作系统");
    }
}
