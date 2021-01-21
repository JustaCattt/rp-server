package com.example.payments.service;

import com.example.payments.entity.Payer;

import java.util.List;

public interface PayerService {

    void savePayerInfo(Payer payer);

    List<Payer> getAll();
}
