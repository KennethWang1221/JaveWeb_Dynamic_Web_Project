package com.ch5.ThreadTest1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest1 implements Callable {
    /*
    * Callable 接口实现线程，一般需要四步
    * 1.设计实现类
    * 2.重写call方法
    * 3.封装成FutureTask对象
    * 4.将futureTask对象在封装为Thread，然后start
    * */




    public static void main(String[] args) {
        //启动线程
        CallableTest1 ct1=new CallableTest1();
        FutureTask ft=new FutureTask(ct1);
        Thread td1=new Thread(ft);
        td1.start();

        //由于多线程 操作系统的线程调度器，控制的，所以有一些不确定性
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //可以使用futureTask的get方法，获取call方法的返回值

        try{
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




    }
    @Override
    public Integer call() throws Exception {
        int m=0;
        for(int i=0;i<6000;i++) {
            //m=new Random.nextInt();
            System.out.println(Thread.currentThread().getName()+" 输出的内容 ");
        }
        return m ;
    }
}
