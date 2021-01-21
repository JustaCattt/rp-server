package com.example.payments.controller;

import com.example.payments.entity.Payments;
import com.example.payments.entity.Result;
import com.example.payments.service.PaymentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin //允许跨域
@Slf4j
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

//    @PostMapping("/set")
//    public Result setPayments(@RequestBody Payments payments){
//        Result result = new Result();
//        log.info("设置的缴费项目为："+payments);
//        try{
//            paymentsService.savePayments(payments);
//            result.setMsg("设置成功！");
//        }catch (Exception e){
//            e.printStackTrace();
//            result.setMsg(e.getMessage()).setState(false);
//        }
//        return result;
//    }

    @PostMapping("/update")
    public Result updatePayments(@RequestBody Payments payments){
        Result result = new Result();
        log.info("更新的缴费项目为："+payments);
        try{
            paymentsService.updatePayments(payments);
            result.setMsg("设置成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @RequestMapping("/get")
    public Result getPayments(){
        Result result = new Result();
        try{
            result.setMsg("获取成功~").setPayInfo(paymentsService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }
}
