package com.ch5.ThreadTest1;

public class RunableTest1 implements Runnable {
    /** 让当前类实现runnable接口，重写run方法，实现线程
    * */



    @Override
    public void run() {
        for(;;) {
            System.out.println(Thread.currentThread()+" 输出的内容");
        }
    }

    public static void main(String[] args) {
        //创建线程类的对象
        RunableTest1 rt1=new RunableTest1();
        //将线程对象传递给Thread对象，才能通过thread 调用start
        Thread th1=new Thread(rt1);
        //真正的线程任务，还是执行runnable实现类中的run方法
        //主线程任务
        th1.start();
        for(;;) {
            System.out.println("main() 输出的内容");
        }

    }
}











