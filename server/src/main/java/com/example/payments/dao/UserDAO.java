package com.example.payments.dao;

import com.example.payments.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDAO {

    //根据用户名查询用户
    User findByUsername(String username);

    //根据id查用户
    User findById(String id);

    //注册用户
    void saveUserInfo(User user);

}
