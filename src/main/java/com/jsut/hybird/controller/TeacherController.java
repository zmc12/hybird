package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:01
 */

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @GetMapping("/selectById")
    public Teacher selectById(@RequestParam("id")Integer id){
        Teacher teacher = teacherService.selectById(id);
        return teacher;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Teacher> insert(Teacher teacher){
        List<Teacher> teachers = teacherService.insertT(teacher);
        System.out.println(teacher.toString());
        return teachers;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Teacher> selectAll(){
        List<Teacher> teachers = teacherService.selectAll();

        return teachers;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Teacher> updateById(Teacher teacher){
        List<Teacher> teachers = teacherService.updateById(teacher);
        return teachers;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Teacher> deleteById(@RequestParam("id") Integer id){
        List<Teacher> teachers = teacherService.deleteById(id);
        System.out.println(teachers.toString());
        return teachers;
    }
}
