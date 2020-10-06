package com.ch5.ThreadTest1.SellTicketsTest3;

public class SellTicketsTest3 {
    public static void main(String[] args) {
        TicketWindow3 tw3=new TicketWindow3();
        Thread tt1=new Thread(tw3,"窗口一：");
        Thread tt2=new Thread(tw3,"窗口二：");
        Thread tt3=new Thread(tw3,"窗口三：");
        Thread tt4=new Thread(tw3,"窗口四：");

        tt1.start();
        tt2.start();
        tt3.start();
        tt4.start();
    }
}
