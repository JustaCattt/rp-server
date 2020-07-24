package com.example.payments.dao;

import com.example.payments.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDAO {

    Admin findByUsername(String username);

}
