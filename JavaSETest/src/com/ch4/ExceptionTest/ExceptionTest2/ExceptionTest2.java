package com.ch4.ExceptionTest.ExceptionTest2;

public class ExceptionTest2 {
    /*
     * 演示自定义异常，以及throw和throws关键词
     *
     *
     * */

    //定义一个除法方法，两个int 参数
    public int div(int a,int b)throws ExceptionDivByFushu{
        //规定除数如果为负数，则会产生异常。
        int res=0;
        if(b<0) {
            //产生异常了，异常是什么？ 异常是一种对象，属于某种异常类的对象
            /*
            * 自定义的异常类对象， 需要程序员自己根据情况，实例化并且抛出
            *
            * */

            throw new ExceptionDivByFushu("除数不能为负数，这是规定");
        }
        else {
            res=a/b;
        }
        return res;
    }


    //假设div 方法，不是直接在main方法中访问，而是在另一个对象方法中先调用
    public void callDiv(int a,int b) throws ExceptionDivByFushu {
        int res=this.div(a,b);
        System.out.println("res="+res);
    }


    public static void main(String[] args) {
        ExceptionTest2 et2=new ExceptionTest2();

        int res=0;
        try{
            res=et2.div(5,-2);
        }catch (ExceptionDivByFushu e){
            e.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("最后捕获的异常");
        }
        finally{
            System.out.println("finally语句块总是会执行");
        }
        System.out.println("res="+res);
    }
}
