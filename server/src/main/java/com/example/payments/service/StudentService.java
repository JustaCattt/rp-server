package com.example.payments.service;

import com.example.payments.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStuInfo(Student student);

    Student getStuInfo(String stuId);

    List<Student> getAll();

    void removeStuInfo(String stuId);

    void init();
}
