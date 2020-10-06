package cn.itcast.action;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class ListDemoAction extends ActionSupport {
    // 1 定义list变量
    private List<User> list=new ArrayList<User>();

    // 2 get 方法
    public List<User> getList() {
        return list;
    }

    public String execute() throws Exception {
        // 3 向list中设置值
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
