package com.ch5.ThreadTest1.SellTicketsTest2;

import java.util.concurrent.FutureTask;

public class SellTicketsTest2 {
    public static void main(String[] args) {
        /*TicketWindow2 tw2=new TicketWindow2();
        Thread th1=new Thread(tw2);
        Thread th2=new Thread(tw2);
        Thread th3=new Thread(tw2);
        Thread th4=new Thread(tw2);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        new Thread().start();*/



        TicketWindow2 tw2=new TicketWindow2();
        FutureTask ft1=new FutureTask(tw2);
        FutureTask ft2=new FutureTask(tw2);
        FutureTask ft3=new FutureTask(tw2);
        FutureTask ft4=new FutureTask(tw2);
        Thread th1=new Thread(ft1,"线程一");
        Thread th2=new Thread(ft2,"线程二");
        Thread th3=new Thread(ft3,"线程三");
        Thread th4=new Thread(ft4,"线程四");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
