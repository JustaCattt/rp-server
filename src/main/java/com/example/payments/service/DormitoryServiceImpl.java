package com.example.payments.service;

import com.example.payments.dao.DormitoryDAO;
import com.example.payments.entity.Dormitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DormitoryServiceImpl implements DormitoryService{

    @Autowired(required = false)
    private DormitoryDAO dormitoryDAO;

    @Override
    public void saveDormitory(Dormitory dormitory) {
        dormitoryDAO.saveDormitory(dormitory);
    }

    @Override
    public Dormitory getDormitory(String stuId) {
        return dormitoryDAO.findByStuId(stuId);
    }
}
