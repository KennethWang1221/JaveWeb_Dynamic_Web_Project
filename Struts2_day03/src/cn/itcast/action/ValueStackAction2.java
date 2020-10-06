package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValueStackAction2 extends ActionSupport {
    //1 定义变量

    private String name;

    //2 生成变量的get 方法
    public String getName() {
        return name;
    }

    public String execute() {
        //使用第三种方法
        //在执行的方法里面向变量设置值
        name="abcdefg";

        return "vsa2";
    }
}
