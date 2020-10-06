package com.ch5.ThreadTest1;


/*
* Java设计线程的第一种方法，
*
* */
public class ThreadTest1 extends Thread {
    public static void main(String [] args) {
        ThreadTest1 tt1=new ThreadTest1();
        tt1.start();
        for(;;){
            System.out.println("main() 线程输出的内容。。。");
        }
    }
}



