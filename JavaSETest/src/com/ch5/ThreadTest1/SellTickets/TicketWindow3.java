package com.ch5.ThreadTest1.SellTickets;


//封装同步方法的自定义线程类，实现Runnable接口
public class TicketWindow3 implements Runnable {
    private int tickets=100;

    public void run() {
        sell();
    }

    //要使用同步方法，控制对线程的同步问题，需要设计一个方法，处理多线程的任务
    public synchronized void sell() {
        Object obj =new Object();
        while(tickets>0) {

                System.out.println(Thread.currentThread().getName()+"出售了 第"+tickets+"票");
                tickets--;



            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
