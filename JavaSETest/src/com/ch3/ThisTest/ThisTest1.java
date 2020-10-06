package com.ch3.ThisTest;

public class ThisTest1 {

    /*
    * 实际开发中，类中的构造器往往需要定义多个，重载机制
    * 就有可能出现，在一个构造方法中调用本类其他的构造方法。
    * 这种情况就需要使用this关键字。
    *
    * */
    private int age;
    private String name;
    private float weight;
    private float height;

    //重载的构造方法
    public ThisTest1() {
        System.out.println("这是无参构造器打印的语句");
    }

    public ThisTest1(int age,String name) {
        this.age=age;
        this.name=name;
    }

    public ThisTest1(int age,String name,float weight) {
        this.age=age;
        this.name=name;
        this.weight=weight;
    }



    public void setHeight(float height) {
        this.height=height;
    }

    public float getHeight() {
        return this.height;
    }

    public void printinfo() {
        System.out.println("name="+this.name+"age="+this.age+
                "weight="+this.weight+"height="+this.height);
    }

    public static void main(String[] args){
        ThisTest1 t1=new ThisTest1(3,"老虎",77);
        t1.setHeight(180);
        t1.printinfo();

        /*
        * 下面这句不可以输出，且报错，因为在静态方法中，不能使用非静态变量，name age weight
        * 这些变量在上边定义都是非静态变量，而非 static name 这种静态变量，所以不能如下输出
        *
        * 需要创建对象再去引用它，例如只给这个"name"赋了值name=张三，然后就想在主函数
        * 中调用它这是不够的，因为它还没有内存，要想有内存，必须要创建了对象，然后赋值，
        * 只有创建了对象后才能有内存空间
        *
        *System.out.println("name="+name+"age="+age+"weight="+weight);
        * */

        /*
        * 这句可以执行，因为有内存了，t1.name t1.age t1.weight
        * 再用t1这个对象去调用name，他就有了内存，这样就可以在静态方法中使用了。
        * */
        //System.out.println("name="+t1.name+"age="+t1.age+"weight="+t1.weight);

        //下面这一句可以执行，因为hello是字符串常量本身就有内存
        //不是变量，变量需要创建对象才能在静态方法中使用
        System.out.println("hello");


    }
}
