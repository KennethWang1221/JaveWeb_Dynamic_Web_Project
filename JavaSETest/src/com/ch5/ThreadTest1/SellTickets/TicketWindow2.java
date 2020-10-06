package com.ch5.ThreadTest1.SellTickets;

public class TicketWindow2 implements Runnable {
    /*
    * 使用实现Runnable 接口的方法，来模拟多个窗口售票程序
    * 1.封装线程类，实现runnable接口
    * 2.重写run方法，在run方法中设计线程任务程序
    * 3.使用Thread对象，将线程对象代理启动
    *
    *
    * 实现Runable接口的方式，有两大优点：
    * 1 节省了极其珍贵的extends关键字
    * 2 可以多个线程共享某些资源，多个Thread 对象，代理同一个目标（对象）
    *
    * */


    //封装票的属性
    private int tickets=100;
    //定义一个同步锁对象，任意的对象都可以
    //String str=""
    Object obj=new Object();

    public void run() {
        /*
        * 同步代码块，对多线程的同步进行控制
        * 同步代码块的"锁"是一个对象，只要能被多个线程共同看到，也就共享的对象就可以，任意的对象！
        * */

        while(tickets>0) {
            synchronized(obj) {
                System.out.println(Thread.currentThread().getName()
                        +" 出售了NO." +tickets+"张票");
                tickets--;
            }
        }

        //控制速度，否则速度太快，一个线程经常就做完了
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
