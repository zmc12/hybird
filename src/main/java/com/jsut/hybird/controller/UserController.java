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
import javax.servlet.http.HttpSession;

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
    public ResultCode login1(@RequestParam("user")String user, @RequestParam("password")String password, HttpSession session){


        Teacher teacher=teacherService.selectByUser(user,password);

        if("".equals(teacher) || teacher==null){
            return new ResultCode(400,"登陆失败");
        }else {
            session.setAttribute("college",teacher.getCollege());
            session.setAttribute("name",teacher.getName());
            UserTeacher.COLLEGE=teacher.getCollege();
            UserTeacher.Name=teacher.getName();
            return new ResultCode(200,"登陆成功");
        }

    }



    @ApiOperation(value = "学生登陆")
    @ResponseBody
    @PostMapping("/student")
    public ResultCode login2(@RequestParam("user")String user, @RequestParam("password")String password,HttpServletResponse response,HttpSession session){
        Student student = studentService.selectByUser(user, password);

        if("".equals(student) || student==null){
            return new ResultCode(400,"登陆失败");
        }else {
            Cookie[] cookie = new Cookie[6];
            Cookie cookie0 = new Cookie("name", student.getName());
            Cookie cookie1 = new Cookie("college", student.getCollege());
            Cookie cookie2 = new Cookie("id", student.getId().toString());
            Cookie cookie3 = new Cookie("userName",student.getUserName());
            Cookie cookie4 = new Cookie("password", student.getPassword());
            Cookie cookie5 = new Cookie("grade", student.getGrade());

            cookie[0]=cookie0;
            cookie[1]=cookie1;
            cookie[2]=cookie2;
            cookie[3]=cookie3;
            cookie[4]=cookie4;
            cookie[5]=cookie5;
            for(int i=0; i<cookie.length;i++){
                cookie[i].setMaxAge(60*60*24*7);
                cookie[i].setPath("/");
                response.addCookie(cookie[i]);
            }

            session.setAttribute("name", student.getName());
            session.setAttribute("college", student.getCollege());
            session.setAttribute("id", student.getId().toString());
            session.setAttribute("userName",student.getUserName());
            session.setAttribute("password", student.getPassword());
            session.setAttribute("grade", student.getGrade());
            UserStudent.COLLEGE=student.getCollege();
            UserStudent.Name=student.getName();
            return new ResultCode(200,"登陆成功");
        }

    }
}
