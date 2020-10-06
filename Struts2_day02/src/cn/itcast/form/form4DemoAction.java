package cn.itcast.form;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
/*
* struts2 封装获取表单数据方式
*
* 原始方式获取表单封装到实体类对象
*
* */
public class form4DemoAction extends ActionSupport {
    public String execute() {
        HttpServletRequest request= ServletActionContext.getRequest();

        // 1 获取表单里的数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");

        // 2 封装到实体类对象里面
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);

        System.out.println(user);



        return NONE;
    }
}
