package cn.itcast.data;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
* 使用模型驱动方式获取表单数据  重点 ！！！ 用的最多！！！
*
* */
public class DataDemo2Action extends ActionSupport implements ModelDriven<User> {
    //创建对象
    //前提要求，表单输入项 name 属性值 和 实体属性名称 一样
    private User user= new User();

    @Override
    public User getModel() {
        return user;
    }

    /*
    *  使用模型驱动和属性封装注意问题
    * （1）在一个action中，获取表单数据可以属性封装，也可以使用模型驱动封装
    *      但是，不能同时使用属性封装和模型驱动封装获取同一个表单数据，
    *      如果同时使用，只会执行模型驱动。
    * */

    //属性封装
    private String username;
    private String password;
    private String address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String execute() throws Exception {
        System.out.println(user);
        return NONE;
    }


}
