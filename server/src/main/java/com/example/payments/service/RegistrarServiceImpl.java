package com.example.payments.service;

import com.example.payments.dao.RegistrarDAO;
import com.example.payments.entity.Registrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrarServiceImpl implements RegistrarService{
    @Autowired(required = false)
    private RegistrarDAO registrarDAO;

    @Override
    public void saveRegistrarInfo(Registrar registrar) {
        if(registrarDAO.findByStuId(registrar.getStuId())==null){
            registrarDAO.saveRegistrarInfo(registrar);
        }else {
            throw new RuntimeException("该生已报道过了");
        }
    }

    @Override
    public List<Registrar> getAll() {
        List<Registrar> list = new ArrayList<>();
        list.addAll(registrarDAO.findAll());
        return list;
    }
}
