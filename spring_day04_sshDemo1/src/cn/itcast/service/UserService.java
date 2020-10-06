package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;

public class UserService {

    //注入dao 对象
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
    public void add() {
        System.out.println("service ....");
        userDao.add();
    }

}
