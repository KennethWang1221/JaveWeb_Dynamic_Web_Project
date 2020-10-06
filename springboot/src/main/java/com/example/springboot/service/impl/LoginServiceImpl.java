package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(User user) {
        //User userFromDb = userMapper.selectByUserName(user.getName)
        //User userFromDb = userMapper.selectByPrimaryKey(user.getId());
        String result = "no";
        User userFromDb = userMapper.userlogin(user.getUsername(), user.getPassword());
        if(user.getUsername().trim().equals(userFromDb.getUsername())) {
            if (user.getPassword().trim().equals(userFromDb.getPassword())) {
                result = "OK";
                return result;
            }
        }

        return result;

    }



    @RequestMapping(value = {"/userAccount"})
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){

        User user = userLoginService.userLogin(username,password);

        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",user);     //将用户信息放入session
            return "index";
        }
        return "userAccount";
    }
}
