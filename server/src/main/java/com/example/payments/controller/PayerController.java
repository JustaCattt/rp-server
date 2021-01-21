package com.example.payments.controller;

import com.example.payments.entity.Payer;
import com.example.payments.entity.Result;
import com.example.payments.entity.User;
import com.example.payments.service.PayerService;
import com.example.payments.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@CrossOrigin //允许跨域
@Slf4j
public class PayerController {

    @Autowired
    private PayerService payerService;
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public Result savePayerInfo(String userId,String stuId){
        Result result = new Result();
        log.info("支付者用户id： "+userId+"   学号： "+stuId);
        User user = userService.findById(userId);
        Payer payer =new Payer();
        payer.setUserId(userId);
        payer.setUsername(user.getUsername());
        payer.setStuId(stuId);
        payer.setRealName(user.getRealName());
        try{
            payerService.savePayerInfo(payer);
            result.setMsg("支付成功！").setPayerInfo(payer);
            log.info("支付成功!"+result.getState());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @GetMapping("/getList")
    public Result getAllPayer(){
        Result result = new Result();
        try{
            log.info("list： " + payerService.getAll());
            result.setMsg("获取成功~").setPayerInfoList(payerService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }
}
