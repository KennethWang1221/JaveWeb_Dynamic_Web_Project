package com.ch3.Bird;

public class BirdDefine {

        /*
        设计一个用于表示鸟的类，比如需要开发一个宠物商店系统，在程序中设计类，
        本质是一个将实际事物抽象出变量和方法的过程

        变量，就是这种类型的对象，他们的共性特征
        方法，就是这种类型的对象，他们能展现的功能
        类的设计有一个特点，自己的事情自己做


        * */
        //对象变量每个对象单独拥有一份。对象之间对象变量互不干扰
        //能不能让一个类的多个不同对象，共享一个变量？---可以，需要使用"静态变量"
        //
        //类中可以定义静态变量，称作类变量
        static int num=9;


        private String type=null;
        public String name;
        public float height;
        public float weight;
        private int age;


        //设计一个给对象变量赋值的方法
        public void setType(String t) {
            this.type=t;
        }
        public void setAge(int a) {
            this.age=a;
        }



        //定义方法
        public void fly() {
            System.out.println(type+"这种鸟飞的很远。他已经"+age+"岁了");
        }

        public void eat() {
            System.out.println(type+"这种鸟需要吃东西。");
        }

        //根据实际需求，可能还会有特定的方法






}

