package com.ch4.Annoymity.Annoymity2;

public class Mainannoymity2 extends SoftWare implements Phone,ReleaseTime {
    /*
    * 因为使用到了继承，主类继承了一个类和两个接口，
    * 所以要在这个主类中重写普通类中的方法，
    * 而且一定要重写实现在接口中的所有方法
    *
    *
    * 如若主类不继承，则不用重写接口中的方法 见Annoymity3 4
    *
    * （想要在什么类中实现接口中的方法，就要再此类中重写实现此方法）
    *
    * 以下就是重写了两个接口中的，四个方法，如果不写重写实现以下方法，程序会报错
    *
    * 如果不用继承直接主类class Mainanonymity2 就不用重写方法 就直接使用多态
    * （见例子 Multiple）
    *
    * 或者 匿名内部类实现多态，就不用再重写实现以下四个接口中的方法
    *
    * */

    /*public void time() {

    }
    public void band() {
        //System.out.println("主类")
        *//*因为band 是接口里边的方法这里只是在主类里边实现，
        方法体里边写不写东西都不影响程序正常输出！*//*
    }
    public void country(){

    }
    public void money() {

    }*/

    @Override
    public void band() {

    }

    @Override
    public void country() {

    }

    @Override
    public void money() {

    }

    @Override
    public void time() {

    }




    public void getOs(SoftWare sw) {
        sw.os();
    }

    public void getPhone(Phone ph) {
        ph.band();
        ph.country();
        ph.money();
    }

    public void getRelease(ReleaseTime re){
        re.time();
    }

    public static void main(String[] args) {
        Mainannoymity2 ma=new Mainannoymity2();


        //以下创建一个匿名内部类，实现苹果手机的功能
        ma.getOs(new SoftWare() {
            public void os(){
                System.out.println("这是定义在匿名类中的苹果iOS操作系统方法");
            }
        });

        ma.getPhone(new Phone(){
            public void band() {
                System.out.println("iPhone 6pppp 64GB");
            }
             public void country() {
                 System.out.println("美国");
            }
            public void money() {
                System.out.println("44444444");
            }
        });

        ma.getRelease(new ReleaseTime() {
            @Override
            public void time() {
                System.out.println("7月份发布");
            }
        });


        //以下创建一个匿名内部类，实现华为手机的功能
        ma.getOs(new SoftWare(){
            public void os() {
                System.out.println("android操作系统");

            }
        });

        ma.getPhone(new Phone(){
            public void band(){
                System.out.println("华为手机");
            }
            public void country(){
                System.out.println("中国");
            }
            public void money(){
                System.out.println("7800");
            }
        });

        ma.getRelease(new ReleaseTime(){
            public void time() {
                System.out.println("16年9月份");
            }
        });

    }
}
