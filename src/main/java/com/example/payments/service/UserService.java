package com.example.payments.service;

import com.example.payments.entity.User;

public interface UserService {

    void register(User user);
    User login(User user);
    User findById(String userId);
}
