package com.example.payments.dao;

import com.example.payments.entity.Payer;
import com.example.payments.entity.Registrar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegistrarDAO {

    //将注册者信息存入名单中
    void saveRegistrarInfo(Registrar registrar);

    //通过学号查看是否报道过了
    Registrar findByStuId(String stuId);

    //返回一个报道者名单
    List<Registrar> findAll();
}
