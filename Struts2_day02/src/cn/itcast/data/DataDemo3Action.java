package cn.itcast.data;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
* 使用表达式形式进行封装数据,也可以把数据封装到实体类中去。
*
* 把表达式封装 归类到 属性封装 里面 也可以
* */
public class DataDemo3Action extends ActionSupport {
    // 1 声明实体类
    private User user;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // 2 生成实体类变量的set方法和get方法
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public String execute() {
        System.out.println(user);
        System.out.println(book);
        return NONE;
    }

}
