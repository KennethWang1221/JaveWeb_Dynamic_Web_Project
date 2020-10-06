package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //第一种 方式使用 值栈对象 里面的 set 方法
        //1 获取 ActionContext 类里面的对象
        ActionContext context=ActionContext.getContext();
        //获取值栈对象
        ValueStack stack=context.getValueStack();
        // 2 调用方法 set 方法

        stack.set("username","itcastheima");

        // 第二种 调用方法 push 方法

        stack.push("abcd");
        return "success";


    }
}
