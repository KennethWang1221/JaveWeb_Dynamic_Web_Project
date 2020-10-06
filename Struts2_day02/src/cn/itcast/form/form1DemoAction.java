package cn.itcast.form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
//import org.apache.struts2.dispatcher.HttpParameters;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class form1DemoAction extends ActionSupport {



    @Override
    public String execute() throws Exception {
        //第一种方式 使用ActionContext 类获取
        // 1 获取 ActionContext 对象
        ActionContext context= ActionContext.getContext();
        // 2 调用方法得到表单数据
        // key 是表单输入项目 name 属性值，value 是输入的值

       /* Map<String,Object> map=context.getParameters();
        Set<String> keys= map.keySet();
        for(String key : keys) {
            //根据key得到value
            //数组形式，因为输入项里面可能有复选框情况
            Object[] obj = (Object[]) map.get(key);
            System.out.println(Arrays.toString(obj));
        }*/


        /*
        * 在action 操作域对象 示例
        * 1 request session servletContext
        * 2 使用 servletActionContext 类操作
        * */

        //  操作三个域对象
        // 1 request 域
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("req","reqValue");

        // 2 session 域
        HttpSession session=request.getSession();
        session.setAttribute("sess","sessValue");

        // 3 SevletContext 域
        ServletContext context1=ServletActionContext.getServletContext();
        context1.setAttribute("contextname","contextValue");




        return NONE;
    }
}


