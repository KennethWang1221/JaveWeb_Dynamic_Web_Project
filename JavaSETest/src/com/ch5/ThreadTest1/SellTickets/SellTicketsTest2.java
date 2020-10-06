package com.ch5.ThreadTest1.SellTickets;


public class SellTicketsTest2 {
    public static void main(String[] args) {
        /*
        * 通过Thread 代理，启动四个线程，模拟四个售票窗口
        * 真正的线程对象，就是真正处理任务的线程类的对象
        * */

        TicketWindow3 tw1= new TicketWindow3();


        Thread th1=new Thread(tw1,"窗口一");
        Thread th2=new Thread(tw1,"窗口二");
        Thread th3=new Thread(tw1,"窗口三");
        Thread th4=new Thread(tw1,"窗口四");

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        //观察StringBuffer 和 StringBuilder ，体会理解线程的同步
       // StringBuffer sbf=new StringBuffer();
        //StringBuilder sb1=new StringBuilder();

        /*
        * StringBuffer 是线程安全的，本质就是它所有的API方法，几乎都是synchronized的的方法
        * Synchronized的方法
        * 而StringBuilder是线程不安全的，本质就是其所有API方法，都是普通的方法
        * */

    }
}
