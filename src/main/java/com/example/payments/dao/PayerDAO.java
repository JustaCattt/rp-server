package com.example.payments.dao;

import com.example.payments.entity.Payer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayerDAO {

    //将支付者信息存入名单中
    void savePayerInfo(Payer payer);

    //通过学号来查询是否缴过费
    Payer findByStuId(String stuId);

    //返回一个支付者名单
    List<Payer> findAll();
}
