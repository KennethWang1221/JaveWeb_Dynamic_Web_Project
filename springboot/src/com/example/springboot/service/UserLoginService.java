package com.example.springboottest1.service;

import com.example.springboot.entity.User;
import com.example.springboottest1.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLoginService {

    /**
     * 注入dao
     */
    @Autowired
    private userMapper usermapper;

    //用户登录
    public User userLogin(String username,String password){
        User user = usermapper.userlogin(username,password);
        return user;
    }

    //注册新用户
    public int adduser(String username,String password,int age){


        return usermapper.adduser(username,password,age);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }
}
