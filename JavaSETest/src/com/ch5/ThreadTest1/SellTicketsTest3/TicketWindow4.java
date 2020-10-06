package com.ch5.ThreadTest1.SellTicketsTest3;

import java.util.concurrent.Callable;

public class TicketWindow4 implements Callable {
    private int tickets=100;
    Object obj =new Object();

    public Integer call() {
        int m=0;
        while(tickets>0) {
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+"出售了 第"+tickets+"张票");
                tickets--;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return m;
    }

   /* public Integer call() {
        int m=0;
        sell();
        return m;

    }

    public synchronized void sell()  {
        while(tickets>100) {
            System.out.println(Thread.currentThread().getName()+" 出售了 第"+tickets+" 票");
            tickets--;

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/











}
