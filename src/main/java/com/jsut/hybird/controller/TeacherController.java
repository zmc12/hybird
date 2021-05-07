package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.TeacherService;
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
 * @Date: 2021/3/2 12:01
 */

@Api(value = "教师管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation(value = "查询教师")
    @ResponseBody
    @GetMapping("/selectById")
    public Teacher selectById(@RequestParam("id")Integer id){
        Teacher teacher = teacherService.selectById(id);
        return teacher;
    }

    @ApiOperation(value = "新增教师")
    @ResponseBody
    @PostMapping("/insert")
    public List<Teacher> insert(Teacher teacher){
        List<Teacher> teachers = teacherService.insertT(teacher);
        System.out.println(teacher.toString());
        return teachers;
    }

    @ApiOperation(value = "查询所有教师")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Teacher> selectAll(){
        List<Teacher> teachers = teacherService.selectAll();

        return teachers;
    }
    @ApiOperation(value = "更新教师")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Teacher> updateById(Teacher teacher){
        List<Teacher> teachers = teacherService.updateById(teacher);
        return teachers;
    }

    @ApiOperation(value = "删除教师")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Teacher> deleteById(@RequestParam("id") Integer id){
        List<Teacher> teachers = teacherService.deleteById(id);
        System.out.println(teachers.toString());
        return teachers;
    }
}
