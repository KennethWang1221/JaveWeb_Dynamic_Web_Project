package cn.itcast.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
/*
* 使用第三种接口注入方式
* */
public class form3DemoAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;

    }

    public String execute() throws Exception {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        System.out.println(username+"::"+password+"::"+address);
        return NONE;
    }
}
