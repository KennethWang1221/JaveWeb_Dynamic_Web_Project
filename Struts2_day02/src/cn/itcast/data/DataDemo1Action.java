package cn.itcast.data;

import com.opensymphony.xwork2.ActionSupport;
/*

  属性封装：

* 原理：jsp表单数据读出来，和action username匹配，相同则调用setXXX方法写进来
* b站 Struts2 p26 09-属性封装操作 10分钟开始讲解
*
* */
public class DataDemo1Action extends ActionSupport {
    // 1 定义变量
    //   变量的名称和表单输入项name属性值一样

    private String username;
    private String password;
    private String address;

    //2 生成变量的set和get方法

    /*
    * 缺点： 使用属性封装获取表单数据到属性里面，不能把数据直接封装到实体类对象里面
    * 实质上只是省略了
    *   String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        以上代码
        如果业务逻辑需要写到对象中去还需要 new个对象，写一下代码才行
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);

    * 针对这个情况（缺陷）struts2 进而提供了 第二种方式 模型驱动封装（重点）
    * 最大的优点：1.使用模型驱动方式，可以直接把表单数据封装到实体类对象里面
    * 相当于不用写以下代码了
    *   String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
    *
    * */
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

    public String execute() {

        System.out.println(username+":"+password+":"+address+"~");
        return NONE;
    }
}
