package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.service.TeacherService;
import com.jsut.hybird.utils.UserStudent;
import com.jsut.hybird.utils.UserTeacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 15:15
 */

@Api(value = "登陆管理")
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


    @ApiOperation(value = "教师登陆")
    @ResponseBody
    @PostMapping("/teacher")
    public ResultCode login1(@RequestParam("user")String user, @RequestParam("password")String password, HttpServletResponse response){


        Teacher teacher=teacherService.selectByUser(user,password);

        if("".equals(teacher) || teacher==null){
            return new ResultCode(400,"登陆失败");
        }else {
            Cookie[] cookie = new Cookie[2];
            Cookie cookie0 = new Cookie("name", teacher.getName());
            Cookie cookie1 = new Cookie("college", teacher.getCollege());
            cookie[0]=cookie0;
            cookie[1]=cookie1;
            for(int i=0; i<cookie.length;i++){
                cookie[i].setMaxAge(60*60*24*7);
                cookie[i].setPath("/");
                response.addCookie(cookie[i]);
            }
//            UserTeacher.COLLEGE=teacher.getCollege();
//            UserTeacher.Name=teacher.getName();
            return new ResultCode(200,"登陆成功");
        }

    }



    @ApiOperation(value = "学生登陆")
    @ResponseBody
    @PostMapping("/student")
    public ResultCode login2(@RequestParam("user")String user, @RequestParam("password")String password,HttpServletResponse response){
        Student student = studentService.selectByUser(user, password);

        if("".equals(student) || student==null){
            return new ResultCode(400,"登陆失败");
        }else {
            Cookie[] cookie = new Cookie[2];
            Cookie cookie0 = new Cookie("name", student.getName());
            Cookie cookie1 = new Cookie("college", student.getCollege());
            cookie[0]=cookie0;
            cookie[1]=cookie1;
            for(int i=0; i<cookie.length;i++){
                cookie[i].setMaxAge(60*60*24*7);
                cookie[i].setPath("/");
                response.addCookie(cookie[i]);
            }
//            UserStudent.COLLEGE=student.getCollege();
//            UserStudent.Name=student.getName();
            return new ResultCode(200,"登陆成功");
        }

    }
}
