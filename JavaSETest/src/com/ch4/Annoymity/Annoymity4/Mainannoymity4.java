package com.ch4.Annoymity.Annoymity4;


/*
 * 这是annoymity 匿名内部类，从最初的可成功运行版本修改为完善的版本
 * 使用 scanner 用户输入，switch 语句选择 继承接口后 使用多态
 * */


/*public class Mainannoymity4 extends SoftWare4 implements Phone4,ReleaseTime4 {
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
}*/     //因为主类继承了  法一 上边的接口所以现在要将上边的接口中的所有方法都要实现

//下边 法二 主方法没有继承，所以不需要将接口中的方法都实现

import java.util.Scanner;

public class Mainannoymity4 {
    public void getOs(SoftWare4 sw4) {
        sw4.os();
    }

    public void getPhone(Phone4 ph4) {
        ph4.band();
        ph4.country();
        ph4.money();
    }

    public void getRelease(ReleaseTime4 re4) {
        re4.time();
    }

    public static void main(String[] args) {
        Mainannoymity4 ma4=new Mainannoymity4();
        Scanner sr=new Scanner(System.in);

        int i=1;
        while(i!=0){
            System.out.println();
            System.out.println("请选择您想要了解的手机：");
            System.out.println();
            System.out.println("1.这是苹果手机 ");
            System.out.println("");
            System.out.println("2.这是华为手机 ");
            System.out.println();
            System.out.println("退出请输入0:");
            System.out.println();

            int button =sr.nextInt();
            System.out.println();

            switch(button) {
                case 1:
                    ma4.getOs(new SoftWare4(){
                        public void os(){
                            System.out.println("ios 操作系统");

                        }
                    });

                    ma4.getPhone(new Phone4(){
                        public void band(){
                            System.out.println("苹果手机 iPhone 10");
                        }

                        public void money(){
                            System.out.println("4000000");
                        }

                        @Override
                        public void country() {
                            System.out.println("美国");

                        }
                    });

                    ma4.getRelease(new ReleaseTime4(){
                        public void time(){
                            System.out.println("17年 4月份");

                        }
                    });


                    break;


                case 2:

                    ma4.getOs(new SoftWare4(){
                        public void os() {
                            System.out.println("android 操作系统");
                        }
                    });

                    ma4.getPhone(new Phone4() {
                        public void band(){
                            System.out.println("华为手机 mate20");
                        }

                        public void country() {
                            System.out.println("中国");
                        }
                        public void money() {
                            System.out.println("57897");
                        }
                    });

                    ma4.getRelease(new ReleaseTime4(){
                        public void time(){
                            System.out.println("18年8月份");
                        }
                    });

                    break;

                case 0:
                    System.out.println("您已退出选择");
                    //若注释掉此句，则循环进入了死循环，即使输入了0 程序继续执行
                    i=0;

                    break;

                default:
                    System.out.println("选择有误，请重新选择:");
                    System.out.println("*****************************");
                    System.out.println("");

                    break;


            }
        }
    }







}
