package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class UserService {


    //接口==实现类对象 所以写的属性就是接口
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    //登陆的方法
    public User login(User user) {
        //调用 service  dao 中的方法 返回对象

        /*userDao.loginUser(user);
        return user;*/
        return userDao.loginUser(user);
        //return null;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
