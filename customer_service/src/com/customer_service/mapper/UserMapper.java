package com.customer_service.mapper;

import com.customer_service.entity.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(String pkUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String pkUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //用户登录
    User userlogin(@Param("username") String username,@Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("username") String username, @Param("password") String password, @Param("age") int age);

    //注册新用户（方式2）
    int adduser1(@Param("username") String username, @Param("password") String password, @Param("age") int age);

}
