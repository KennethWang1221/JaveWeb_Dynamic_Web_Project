package com.ch5.ThreadTest1.SellTicketsTest3;

public class TicketWindow3 implements Runnable {
    private int tickets=100;

    Object obj=new Object();

    public void run() {
        while(tickets>0) {
            synchronized (obj){
                //System.out.println("出售了 第 "+tickets+" 张票");//错误语句，若是此句，则无法正常显示线程名称
                System.out.println(Thread.currentThread().getName()+"出售了 第 "+tickets+" 张票");

                tickets--;


            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
