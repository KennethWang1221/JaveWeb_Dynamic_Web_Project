package com.ch3.InnerClassTest;

public class OuterClass2 {
    //测试，非静态内部类，静态内部类，方法内部类
    public int m=1;
    private int n=1;
     static int a=1;

    //定义一个非静态内部类
    class InnerClass1{
        public int m=2;
        private int n=2;

        //非静态内部类中不能定义静态变量，及静态方法
        /*
          static int a=4l;
        * public static void inClass1Method2() {
            System.out.println("（这是非静态内部类的语句输出） inner value="+m);
        }
        * */
        //定义一个内部类方法
        public void inClass1Method() {
            System.out.println("（这是非静态内部类的语句输出） inner value="+m);
        }



    }

    //定义一个静态内部类
    static class InnerClass2 {
        int m=3;
        static int n=3;
        //定义一个静态内部类方法
        public void inClass2Method() {
            System.out.println("(这是静态内部类的语句输出) innerclass2 m="+m+"n="+n);
        }

        public static void inClass2Method2() {
            //静态方法中不能访问非静态变量
            //System.out.println("(这是静态内部类静态方法的语句输出) innerclass2 m="+m+"n="+n);
            System.out.println("(这是静态内部类静态方法的语句输出) innerclass2 n="+n+"a="+a);
        }
    }

    //定义一个方法内部类
    public void OuterMethod() {
        int m=4;
        class InnerClass3 {
            int m=5;
            public void inClassMethod3() {
                System.out.println("这是方法内部类的语句输出 innerclass3 m="+m);
            }

            /*
             * 方法内部类，位置决定了要在其内部，方法内部去实现方法功能
             * 在类中的方式里。定义内部类，其所处的位置相当于一个局部变量，因此一般是在
             * 该方法内部实例化和使用
             *
             * */

            //InnerClass3 in3=new InnerClass3();

        }
        InnerClass3 in3=new InnerClass3();
        in3.inClassMethod3();
        System.out.println("这是方法内部类中成员变量的语句输出 innerclass3 m="+m);

    }

    //定义一个外部类普通方法
    public void OuterMethod2() {
        System.out.println("OuterClass value m="+m);
    }
}
