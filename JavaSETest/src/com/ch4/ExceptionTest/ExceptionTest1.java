package com.ch4.ExceptionTest;


/*
* java 中的异常，先看一个异常的情况，观察异常产生后的影响
*
* */
public class ExceptionTest1 {
    int a=5;
    int b=2;

    //方法
    public int div(int a,int b) {
        return a/b;
    }

    public static void main(String[] args){
        ExceptionTest1 et1=new ExceptionTest1();
        int res=0;
        System.out.println("准备计算商");

        try{
            res=et1.div(5,0);
            System.out.println("这里是try语句块结束位置。");
        }catch (Exception e){
            System.out.println("除零异常");
            System.out.println("这里是catch语句块结束位置");
        }finally {
            System.out.println("这里是finally语句块结束位置");
        }

        System.out.println("**************");
        System.out.println("商="+res);
        System.out.println("程序正常结束");

    }
}
