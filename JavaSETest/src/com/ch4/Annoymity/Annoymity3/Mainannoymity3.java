package com.ch4.Annoymity.Annoymity3;

public class Mainannoymity3 /*extends SoftWare3 implements Phone3,ReleaseTime3*/ {
    //继承了phone3 ReleaseTime3 所以要重写这两个接口中的所有方法


    /*@Override
    public void band() {
        System.out.println("adf");

    }

    @Override
    public void country() {

    }

    @Override
    public void money() {

    }

    @Override
    public void time() {

    }*/


    public void getOs(SoftWare3 sw3) {
        sw3.os();
    }

    public void getPhone(Phone3 ph3) {
        ph3.money();
        ph3.band();
        ph3.country();
    }

    public void getRelese(ReleaseTime3 re4) {
        re4.time();
    }



    public static void main(String[] args) {
        Mainannoymity3 ma3=new Mainannoymity3();

        //实现苹果手机信息输出
        ma3.getOs(new SoftWare3(){
            public void os() {
                System.out.println("iOS操作系统");
            }
        });

        ma3.getPhone(new Phone3(){
            public void band() {
                System.out.println("苹果手机6s plus 64GB");
            }
            public void country() {
                System.out.println("美国");
            }
            public void money(){
                System.out.println("444444");
            }
        });

        ma3.getRelese(new ReleaseTime3(){
            public void time(){
                System.out.println("16年5月");
            }
        });


        //实现华为手机信息输出
        ma3.getOs(new SoftWare3(){
            public void os() {
                System.out.println("android操作系统");
            }
        });

        ma3.getPhone(new Phone3() {
            public void band() {
                System.out.println("huawei手机6s plus 64GB");
            }
            public void country() {
                System.out.println("中国");
            }
            public void money(){
                System.out.println("4432452");
            }
        });

        ma3.getRelese(new ReleaseTime3() {
            public void time() {
                System.out.println("19年底");
            }
        });

    }
}
