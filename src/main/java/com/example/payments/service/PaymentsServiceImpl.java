package com.example.payments.service;

import com.example.payments.dao.PaymentsDAO;
import com.example.payments.entity.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentsServiceImpl implements PaymentsService{

    @Autowired(required = false)
    private PaymentsDAO paymentsDAO;

//    @Override
//    public void savePayments(Payments payments){
//        paymentsDAO.savePayments(payments);
//    }

    @Override
    public void updatePayments(Payments payments) {
        paymentsDAO.updatePayments(payments);
    }

    @Override
    public Payments getAll() {
        return paymentsDAO.findAll();
    }


}
