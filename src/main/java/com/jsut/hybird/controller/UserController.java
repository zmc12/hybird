package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.service.TeacherService;
import com.jsut.hybird.utils.userStudent;
import com.jsut.hybird.utils.userTeacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 15:15
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/login")
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;


    @ResponseBody
    @PostMapping("/teacher")
    public ResultCode login1(@RequestParam("user")String user, @RequestParam("password")String password){

        Teacher teacher=teacherService.selectByUser(user,password);

        if("".equals(teacher) || teacher==null){
            return new ResultCode(400,"登陆失败");
        }else {
            userTeacher.COLLEGE=teacher.getCollege();
            userTeacher.Name=teacher.getName();
            return new ResultCode(200,"登陆成功");
        }

    }



    @ResponseBody
    @PostMapping("/student")
    public ResultCode login2(@RequestParam("user")String user, @RequestParam("password")String password){
        Student student = studentService.selectByUser(user, password);

        if("".equals(student) || student==null){
            return new ResultCode(400,"登陆失败");
        }else {
            userStudent.COLLEGE=student.getCollege();
            userStudent.Name=student.getName();
            return new ResultCode(200,"登陆成功");
        }

    }
}
