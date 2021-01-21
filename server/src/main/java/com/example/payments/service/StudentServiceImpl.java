package com.example.payments.service;

import com.example.payments.dao.StudentDAO;
import com.example.payments.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired(required = false)
    private StudentDAO studentDAO;

    @Override
    public void saveStuInfo(Student student){
        if (studentDAO.findByStuId(student.getStuId())==null){
            studentDAO.saveStuInfo(student);
        }else {
            throw new RuntimeException("学号已存在！");
        }
    }

    @Override
    public Student getStuInfo(String stuId){
        Student studentDB = studentDAO.findByStuId(stuId);
        return studentDB;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        list.addAll(studentDAO.findAll());
        return list;
    }

    @Override
    public void removeStuInfo(String stuId) {
        if(studentDAO.findByStuId(stuId)!=null){
            studentDAO.removeByStuId(stuId);
        }else {
            throw new RuntimeException("学号不存在！");
        }
    }

    @Override
    public void init() {
        if(studentDAO.findAll()!=null){
            studentDAO.init();
        }else {
            throw new RuntimeException("表中已无数据，请勿重复操作！");
        }
    }
}
