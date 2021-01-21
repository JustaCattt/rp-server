package com.example.payments.controller;

import com.example.payments.entity.Result;
import com.example.payments.service.UserService;
import com.example.payments.utils.CreateImageCode;
import com.example.payments.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@CrossOrigin //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpSession session){
        Result result = new Result();
        log.info("当前登录的user: " + user);
        try {
            User userDB = userService.login(user);
            //登录成功后保存用户id
//            request.getServletContext().setAttribute(user1.getId(),user1);
//            session.setAttribute(userDB.getId(),userDB);
            log.info("userDB的Id： "+userDB.getId());
            result.setMsg("登录成功！~~").setUserId(userDB.getId()).setStuId(userDB.getStuId());
        }catch (Exception e){
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @PostMapping("/register")
    public Result register(String code,@RequestBody User user, HttpSession session) {
        Result result = new Result();
        log.info("接收的验证码： " + code);
        log.info("接收到user对象： " + user);
        //验证验证码
        String sessionCode = (String) session.getAttribute("code");
        log.info("生成的验证码： " + sessionCode);
        try {
            if (code.equalsIgnoreCase(sessionCode)) {
                //注册用户
                userService.register(user);
                result.setMsg("注册成功！");
            } else {
                throw new RuntimeException("验证码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }


    @GetMapping("/getImage")
    public void getImage(HttpServletResponse response, HttpSession session) throws IOException {
        CreateImageCode createImageCode = new CreateImageCode();
        //获取验证码
        String securityCode = createImageCode.getCode();
        //验证码存入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //响应浏览器
        response.setContentType("image/png");
        ImageIO.write(image,"png", response.getOutputStream());
    }
}
