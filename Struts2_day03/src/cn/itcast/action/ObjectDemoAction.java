package cn.itcast.action;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;
/*
* 向值栈中放域对象
*
* */
public class ObjectDemoAction extends ActionSupport {
    // 1 定义对象变量
    private User user=new User();
    //生成 get 方法


    public User getUser() {
        return user;
    }



    @Override
    public String execute() throws Exception {
        user.setUsername("lucy");
        user.setPassword("123");
        user.setAddress("美国");


        return SUCCESS;
    }
}
