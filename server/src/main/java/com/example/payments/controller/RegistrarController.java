package com.example.payments.controller;

import com.example.payments.entity.*;
import com.example.payments.service.RegistrarService;
import com.example.payments.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
@CrossOrigin //允许跨域
@Slf4j
public class RegistrarController {

    @Autowired
    private RegistrarService registrarService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/save")
    public Result saveRegistrarInfo(String stuId){
        Result result = new Result();
        log.info("学号： "+stuId);
        Student student = studentService.getStuInfo(stuId);
        log.info("姓名： "+student.getName());
        Registrar registrar = new Registrar();
        registrar.setStuId(stuId);
        registrar.setName(student.getName());
        try{
            registrarService.saveRegistrarInfo(registrar);
            result.setMsg("报道成功！").setRegInfo(registrar);
            log.info("报道成功!"+result.getState());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @GetMapping("/getList")
    public Result getAllRegistrar(){
        Result result = new Result();
        try{
            log.info("list： " + registrarService.getAll());
            result.setMsg("获取成功~").setRegInfoList(registrarService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }
}
