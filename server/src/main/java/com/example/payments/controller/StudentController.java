package com.example.payments.controller;

import com.example.payments.entity.Result;
import com.example.payments.entity.Student;
import com.example.payments.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stu")
@CrossOrigin //允许跨域
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/stuInfo")
    public Result save(@RequestBody Student student){
        Result result = new Result();
        log.info("接收到student对象： " + student);
        try {
            studentService.saveStuInfo(student);
            result.setMsg("录入成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @RequestMapping("/stuReg")
    public Result query(String userId, String stuId){
        Result result = new Result();
        log.info("该用户id为: " + userId);
        log.info("该用户学号: "+stuId);
        Student student = studentService.getStuInfo(stuId);
        log.info("学生信息: ："+student);
        try{
            result.setMsg("查询成功~").setUserId(userId).setStuId(stuId).setStuInfo(student);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @GetMapping("/getList")
    public Result getAllStu(){
        Result result = new Result();
        try{
            log.info("list： " + studentService.getAll());
            result.setMsg("获取成功~").setStuInfoList(studentService.getAll());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @PostMapping("/remove")
    public Result removeStu(String stuId){
        Result result = new Result();
        log.info("请求删除的学号："+stuId);
        try{
            log.info("要删除的学生信息为： "+studentService.getStuInfo(stuId));
            studentService.removeStuInfo(stuId);
            result.setMsg("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @PostMapping("/init")
    public Result initStuList(){
        Result result = new Result();
        try {
            studentService.init();
            log.info("当前表中数据为： "+studentService.getAll());
            result.setMsg("初始化成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }
}
