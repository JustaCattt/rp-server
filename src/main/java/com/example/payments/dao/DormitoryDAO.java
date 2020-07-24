package com.example.payments.dao;

import com.example.payments.entity.Dormitory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DormitoryDAO {
    void saveDormitory(Dormitory dormitory);

    //根据学号查所在宿舍
    Dormitory findByStuId(String stuId);
}
