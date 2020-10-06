package com.ch5.ThreadTest1;

public class TicketWindow extends Thread {

    /** 先封装线程类，用继承Thread类的方式
    * 重写run方法（结束线程的方法是，退出run方法，而不能使用像stop这样的方法）
    * 调用start启动线程
    * */


    //定义属性
    private int tickets=100;//代表有100张可供出售的票

    //重写方法
    public void run() {
        //run 方法中设计线程的任务

        while(tickets>0) {
            //打印那个窗口出售类那张票
            System.out.println(Thread.currentThread().getName()+" 出售了NO."+tickets+"张票。");
            tickets--;
        }
    }
}





















