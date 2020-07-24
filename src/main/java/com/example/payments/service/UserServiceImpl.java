package com.example.payments.service;

import com.example.payments.dao.UserDAO;
import com.example.payments.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        if (userDAO.findByUsername(user.getUsername())==null){
            userDAO.saveUserInfo(user);
        }else {
            throw new RuntimeException("用户名已存在！");
        }
    }

    @Override
    public User login(User user) {
        User userDB = userDAO.findByUsername(user.getUsername());
        if (userDB!=null){
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else {
            throw new RuntimeException("用户名输入错误或不存在！");
        }
    }

    @Override
    public User findById(String userId) {
        User userDB = userDAO.findById(userId);
        if(userDB!=null) {
            return userDB;
        }else {
            throw new RuntimeException("找不到该用户");
        }
    }
}
