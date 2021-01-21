package com.example.payments.service;

import com.example.payments.entity.Dormitory;

public interface DormitoryService {

    void saveDormitory(Dormitory dormitory);

    Dormitory getDormitory(String stuId);
}
