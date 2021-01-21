package com.example.payments.controller;

import com.example.payments.entity.Admin;
import com.example.payments.entity.Result;
import com.example.payments.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
@CrossOrigin //允许跨域
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin, HttpSession session){
        Result result = new Result();
        log.info("user: " + admin);
        try {
            Admin adminDB = adminService.login(admin);
            //登录成功后保存用户id
//            request.getServletContext().setAttribute(user1.getId(),user1);
//            session.setAttribute(adminDB.getId(),adminDB);    好像没用到 先注释掉吧
            log.info("adminDB的Id： "+adminDB.getId());
            result.setMsg("登录成功！~~").setUserId(adminDB.getId());
        }catch (Exception e){
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }
}
