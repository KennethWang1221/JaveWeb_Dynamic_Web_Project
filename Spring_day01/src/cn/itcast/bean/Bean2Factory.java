package cn.itcast.bean;

public class Bean2Factory {
    //静态的方法，返回 Bean2 对象
    public static Bean2 getBean2() {
        return new Bean2();
    }
}
