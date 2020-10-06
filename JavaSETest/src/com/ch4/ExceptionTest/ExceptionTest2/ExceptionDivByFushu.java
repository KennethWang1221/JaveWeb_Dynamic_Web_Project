package com.ch4.ExceptionTest.ExceptionTest2;

public class ExceptionDivByFushu extends Exception {
    //自定义一个异常，表示如果除数为负数，则产生的异常

    //自定义构造器，将异常信息的文本传给父类的构造方法
    public ExceptionDivByFushu(String msg) {
        super(msg);
    }
}
