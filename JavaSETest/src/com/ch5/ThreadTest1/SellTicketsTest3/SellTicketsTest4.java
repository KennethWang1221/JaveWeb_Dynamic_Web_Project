package com.ch5.ThreadTest1.SellTicketsTest3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SellTicketsTest4 {
    public static void main(String[] args){
        TicketWindow4 tw4=new TicketWindow4();
        FutureTask ft1=new FutureTask(tw4);
        FutureTask ft2=new FutureTask(tw4);
        FutureTask ft3=new FutureTask(tw4);
        FutureTask ft4=new FutureTask(tw4);

        Thread th1=new Thread(ft1,"窗口一");
        Thread th2=new Thread(ft2,"窗口二");
        Thread th3=new Thread(ft3,"窗口三");
        Thread th4=new Thread(ft4,"窗口四");

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            System.out.println(ft1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
