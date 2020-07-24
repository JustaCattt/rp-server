package com.example.payments.service;

import com.example.payments.entity.Payments;

public interface PaymentsService {
//    void savePayments(Payments payments);

    void updatePayments(Payments payments);

    Payments getAll();
}
