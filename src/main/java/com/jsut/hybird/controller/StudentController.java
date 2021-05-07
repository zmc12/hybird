package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 16:53
 */

@Api(value = "学生管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @ApiOperation(value = "查询学生")
    @ResponseBody
    @GetMapping("/selectById")
    public Student selectById(@RequestParam("id")Integer id){
        Student student = studentService.selectById(id);
        return student;
    }

    @ApiOperation(value = "新增学生")
    @ResponseBody
    @PostMapping("/insert")
    public List<Student> insert(Student student){
        List<Student> students = studentService.insertT(student);
        System.out.println(student.toString());
        return students;
    }

    @ApiOperation(value = "查询所有学生")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Student> selectAll(){
        List<Student> students = studentService.selectAll();

        return students;
    }

    @ApiOperation(value = "更新学生")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Student> updateById(Student student){
        List<Student> students = studentService.updateById(student);
        return students;
    }


    @ApiOperation(value = "删除学生")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Student> deleteById(@RequestParam("id") Integer id){
        List<Student> students = studentService.deleteById(id);

        return students;
    }


}
