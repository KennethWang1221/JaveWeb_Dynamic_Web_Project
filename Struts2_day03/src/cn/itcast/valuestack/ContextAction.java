package cn.itcast.valuestack;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ContextAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        //向request域中放一个值
        HttpServletRequest request= ServletActionContext.getRequest();

        request.setAttribute("req","reqValue");

        return SUCCESS;
    }
}
