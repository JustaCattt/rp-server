package com.example.payments.dao;

import com.example.payments.entity.Payments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentsDAO {

//    void savePayments(Payments payments);

    void updatePayments(Payments payments);

    Payments findAll();
}
