package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    //创建 对象
    private LinkMan linkMan=new LinkMan();

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    private LinkManService linkManService;

    //注入客户的service 对象
    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }


    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public LinkManService getLinkManService() {
        return linkManService;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    //1 到新增联系人页面的方法
    public String toAddPage() {
        //1.1 查询所有客户，把所有客户list集合传递到页面中显示（放到域对象）
        //调用客户service里面的方法得到所有客户


        //1.1 查询所有客户，把所有客户 list 集合传递到页面显示 （放到域对象）
        //调用客户servlet 里面的方法 得到所有客户

        List<Customer> listCustomer=customerService.findAll();
        //将 集合 listCustomer 放到域对象中
        ServletActionContext.getRequest().setAttribute("listCustomer",listCustomer);

        return "toAddPage";

    }


    //多条件查询
    public String moreCondition() {

        //调用方法得到条件结果
        List<LinkMan> list=linkManService.findCondition(linkMan);
        ServletActionContext.getRequest().setAttribute("list",list);
        return "moreCondition";
    }

    //6 到联系人添加的页面
    public String toSelectPage() {
        //查询所有客户，把他们传递到页面下拉列表中
        List<Customer> list=customerService.findAll();
        ServletActionContext.getRequest().setAttribute("list",list);

        return "toSelectPage";
    }


    //5 修改联系人
    public String updateLinkMan() {
        linkManService.updateLink(linkMan);
        return "updateLinkMan";
    }

    //4 到修改联系人页面
    public String showLinkMan() {
        //使用模型驱动得到 id 值
        int linkid=linkMan.getLinkid();
        //这里的link 是
        // LinkManAction -> LinkManService -> LinkManDao -> LinkManDaoImpl
        //最终经过 LinkManDaoImpl 中的 findOne 方法 最终return 回来的
        //所以返回的link中就有联系人的信息
        LinkMan link=linkManService.findOne(linkid);

        //需要所有客户的list集合
        List<Customer> listCustomer=customerService.findAll();


        //放到域对象
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("linkman",link);
        request.setAttribute("listCustomer",listCustomer);
        return "showLinkMan";
    }




    // 3 联系人列表的方法
    public String list() {
        List<LinkMan>list= linkManService.listLinkMan();
        ServletActionContext.getRequest().setAttribute("list",list);
        return "list";
    }

    /*
    * 需要上传文件 （流）
    * 需要上传文件名称
    * (1) 在 action 里面成员变量 位置 定义变量
    *       一个表示上传文件
    *       一个表示文件名称
    * (2) 生成变量的 get 和 set 方法
    *
    *  还有一个变量，上传文件的 mime 类型
    * */

    //1 上传文件
    //变量的名称 需要是表单里面文件上传项的name 值  jsp/linkman/add.jsp 中的 87 行
    private File upload;

    //2 上传文件名称 表里面文件上传项的name 值 再加上 FileName
    private String uploadFileName;

    //生成 变量的 get 和 set 方法


    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }






    //2 添加数据到数据库的方法
    public String addLinkMan() throws IOException {
        /*
        * 判断是否需要上传文件
        * */

        if(upload!=null) {
            //写上传代码
            //在服务器文件夹里面创建文件
            File serverfile= new File("/Users/wangxiang/Code/Idea_Project/ssh_crm/tempTestFile"+"/"+uploadFileName);
            //把上传文件复制到服务器文件里面
            // copyFile() 第一个参数 是本地文件名，第二个参数 是服务器上的文件
            FileUtils.copyFile(upload,serverfile);

        }

        /*
        * 现在出现一个问题：可以封装联系人基本信息
        * 但是有cid 这是客户id 值不能直接封装的
        * 因为在 linkMan 中 没有这个属性
        * 解决办法：可以把 cid 的 值封装到 linkMan 中的 customer 对象中去
        *
        * */

        //原始方式 较为复杂
        /*String scid=ServletActionContext.getRequest().getParameter("cid");
        int cid=Integer.parseInt(scid);

        //创建 customer 对象
        Customer c=new Customer();
        c.setCid(cid);
        linkMan.setCustomer(c);*/

        linkManService.addLinkMan(linkMan);

        return "addLinkMan";
    }


}
