package cn.itcast.valuestack;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class ValueStackAction extends ActionSupport {
    //从值栈中获取数据--获取字符串
    /*private String username;
    public String getUsername() {
        return username;
    }
    @Override
    public String execute() throws Exception {
        username="itcast";
        return SUCCESS;
    }*/

    //从值栈中获取数据--获取字符串
    /*private User user=new User();

    public User getUser() {
        return user;
    }
    @Override
    public String execute() throws Exception {
        user.setUsername("mary");
        user.setPassword("123");
        user.setAddress("USA");
        return SUCCESS;
    }*/

    private List<User> list=new ArrayList<User>();

    public List<User> getList() {
        return list;
    }

    @Override
    public String execute() throws Exception {
        User user1=new User();

        user1.setUsername("小黑");
        user1.setPassword("123");
        user1.setAddress("美国");

        User user2=new User();
        user2.setUsername("小白");
        user2.setPassword("345");
        user2.setAddress("英国");

        list.add(user1);
        list.add(user2);
        return SUCCESS;
    }
}
