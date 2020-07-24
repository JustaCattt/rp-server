package com.example.payments.service;

import com.example.payments.entity.Registrar;

import java.util.List;

public interface RegistrarService {

    void saveRegistrarInfo(Registrar registrar);

    List<Registrar> getAll();
}
