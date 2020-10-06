package cn.itcast.action;

import apple.laf.JRSUIState;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {
    public UserAction() {
        System.out.println("action 创建了。。。。。");
    }
    public String execute() throws  Exception {
        // 1 获取 ActionContext类的对象
        ActionContext context= ActionContext.getContext();
        // 2 调用方法得到值栈对象
        ValueStack stack1=context.getValueStack();
        ValueStack stack2=context.getValueStack();

        System.out.println(stack1==stack2);
        return NONE;
    }

}
