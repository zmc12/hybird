package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.StudentService;
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

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @ResponseBody
    @GetMapping("/selectById")
    public Student selectById(@RequestParam("id")Integer id){
        Student student = studentService.selectById(id);
        return student;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Student> insert(Student student){
        List<Student> students = studentService.insertT(student);
        System.out.println(student.toString());
        return students;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Student> selectAll(){
        List<Student> students = studentService.selectAll();

        return students;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Student> updateById(Student student){
        List<Student> students = studentService.updateById(student);
        return students;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Student> deleteById(@RequestParam("id") Integer id){
        List<Student> students = studentService.deleteById(id);

        return students;
    }


}
