package com.example.payments.service;

import com.example.payments.dao.PayerDAO;
import com.example.payments.entity.Payer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class PayerServiceImpl implements PayerService{

    @Autowired(required = false)
    private PayerDAO payerDAO;

    @Override
    public void savePayerInfo(Payer payer) {
        if(payerDAO.findByStuId(payer.getStuId())==null){
            payerDAO.savePayerInfo(payer);
        }else {
            throw new RuntimeException("该生已缴过费！");
        }
    }

    @Override
    public List<Payer> getAll() {
        List<Payer> list = new ArrayList<>();
        list.addAll(payerDAO.findAll());
        return list;
    }
}
