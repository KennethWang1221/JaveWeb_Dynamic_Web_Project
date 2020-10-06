package cn.itcast.dao;

import cn.itcast.entity.User;

import java.util.List;

public interface UserDao {

    /*
    * 在dao注入hibernateTemplate对象
    * */
    User loginUser(User user);

    List<User> findAll();
}
