package com.ch5.ThreadTest1.SellTicketsTest2;

import java.util.concurrent.Callable;

/*
 * 使用实现runnable 接口的方法，来模拟多个窗口售票程序
 * 1 封装线程类，实现runnable接口
 * 2 重写run方法，在run方法中设计线程任务程序
 * 3 使用Thread对象，将线程对象代理启动
 *
 * 实现runnable 接口的方式 ，有两大优点：
 * 1 节省了极其珍贵的extends关键字
 * 2 可以多个线程共享某些资源，多个Thread 对象，代理同一个目标（对象）
 *
 * */
public class TicketWindow2 implements Callable {
    /*
    * 使用实现runnable接口的方法，来模拟多个窗口售票程序
    * 1 封装线程类，实现runnable接口
    * 2 重写run方法，在run方法中设计线程任务程序
    * 3 使用thread 对象，将线程对象代理启动
    *
    * 实现runnable 接口的方式，有两大优点：
    * 1 节省了极其珍贵的extends关键字
    * 2 可以多个线程共享某些资源，多个thread 对象，代理同一个目标（对象）
    * */
    private int tickets=100;
    Object obj=new Object();

    public Integer call() {
        int m=0;
        while(tickets>0) {
            synchronized (obj){
             System.out.println(Thread.currentThread().getName()+"出售了第"+tickets+"票");
             tickets--;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        return  m;
    }
}



