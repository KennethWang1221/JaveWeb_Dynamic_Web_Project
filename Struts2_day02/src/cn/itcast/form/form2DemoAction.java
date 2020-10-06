package cn.itcast.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class form2DemoAction extends ActionSupport {
    public String execute() throws Exception {
        //第二种方式，使用servletActionContext类获取
        //1 使用servletActionContext 获取request 对象
        HttpServletRequest request= ServletActionContext.getRequest();
        //2 调用request里面的方法得到结果
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");

        System.out.println(username+":"+password+":"+address);
        return NONE;
    }
}
