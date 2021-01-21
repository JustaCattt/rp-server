package com.example.payments.controller;

import com.example.payments.entity.Dormitory;
import com.example.payments.entity.Result;
import com.example.payments.service.DormitoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dormitory")
@CrossOrigin //允许跨域
@Slf4j
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("/set")
    public Result setDormitory(@RequestBody Dormitory dormitory){
        Result result = new Result();
        log.info("设置的住宿信息为： "+dormitory);
        try{
            dormitoryService.saveDormitory(dormitory);
            result.setMsg("设置成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @RequestMapping("/get")
    public Result getDormitory(String stuId){
        Result result = new Result();
        try{
            result.setMsg("获取成功~").setDormInfo(dormitoryService.getDormitory(stuId));
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }
}
