package com.ch5.ThreadTest1;

public class SellTicketsTest1 {

    /** @author craig
    * 用多线程模拟多窗口售票程序，先使用继承Thread类的方法
    *
    **/

    public static void main(String[] args) {
        //创建并启动四个窗口售票，实际上就是创建四个线程对象
        Thread th1=new TicketWindow();
        Thread th2=new TicketWindow();
        Thread th3=new TicketWindow();
        Thread th4=new TicketWindow();

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        /** 每个售票窗口，都出售了100张票！！
        * 重大的问题！
        * 因为在线程类中，tickets变量是对象变量，则创建几个线程对象，
        * 内存中就有几个改变量，！也就是每个线程对象访问自己的对象变量tickets
        *
        * */



    }
}

