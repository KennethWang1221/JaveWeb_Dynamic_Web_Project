package cn.itcast.anno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {
    // 得到 dao 对象
    // 1 定义dao类型属性

    /*//在 dao 属性 上面 使用 注解 完成对象注入
    @Autowired
    private UserDao userDao;
    //使用注解方式时候 不在需要 set 方法*/


    //首先 name 属性值 里面写的是  你注解创建UserDao对象 value值
    //使用 @Resource 注解
    @Resource(name="userDao")
    private UserDao userDao;

    public void add() {
        System.out.println("addddddd.gg.......");
        userDao.add();
    }
}
