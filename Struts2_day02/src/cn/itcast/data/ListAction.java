package cn.itcast.data;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/*
* 封装数据到list集合
*
* */
public class ListAction extends ActionSupport {
    // 1 声明list 变量
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list=list;
    }





    public String execute() throws Exception {
        System.out.println(list);
        return  NONE;
    }

}
