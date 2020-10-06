package com.ch4.ExtendsTest;

public class Tiger extends Animal1 {
    //定义一个子类
    /*
    * 子类继承父类的关键字是extends ，愿意是扩展的意思，目前称作继承是因为历史翻译的原因。
    * 如果称作"扩展"更为合适
    * 子类继承父类之后，应该继续扩展和增强自己的能力
    *
    * */
    //老虎作为子类，对继承的属性觉得不够用，又继续添加
    float money;//做一次展览的钱

    public void setMoney(float money) {
        this.money=money;
    }

    public float getMoney() {
        return money;
    }

    public Tiger(String type,int age) {
        super("a",10);
        this.type=type;
        this.age=age;
    }


    //子类老虎对父类的功能（方法）也觉得不够，进行添加
    public void exhibition() {
        //可以产生经济效益
        System.out.println(this.name+"做一次展览挣"+this.money+"万元");
    }

    public void intro() {
        System.out.println("我的名字是 "+this.name+"我是 "+this.type+"我 "+this.age+"了");
    }

    /*
    * 由于父类中shout方法的功能有限，老虎不满意，不能展示其威猛
    * */

    //子类老虎对父类的功能（方法）也觉得不适合自己，进行重写
    //子类老虎重写该方法
    public void shout() {
        //super.shout();
        System.out.println("老虎一声吼，天地抖一抖");
    }

    //重写父类的fun2
    public B22 fun2() {
        return new B22();
    }



}
