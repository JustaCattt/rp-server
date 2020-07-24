package com.example.payments.dao;

import com.example.payments.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDAO {

    void saveStuInfo(Student student);

    Student findByStuId(String stuId);

    List<Student> findAll();

    //根据学号删除学生信息
    void removeByStuId(String stuId);

    //清空列表
    void init();
}
