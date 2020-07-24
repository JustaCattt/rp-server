package com.example.payments.service;

import com.example.payments.dao.AdminDAO;
import com.example.payments.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired(required = false)
    private AdminDAO adminDAO;

    @Override
    public Admin login(Admin admin) {
        Admin adminDB = adminDAO.findByUsername(admin.getUsername());
        if (adminDB!=null){
            if(adminDB.getPassword().equals(admin.getPassword())){
                return adminDB;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else {
            throw new RuntimeException("用户名输入错误或不存在！");
        }
    }
}
