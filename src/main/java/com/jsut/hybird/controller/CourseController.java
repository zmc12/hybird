package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Course;
import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.service.CourseService;
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
 * @Date: 2021/5/25 12:43
 */

@Api(value = "选课")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @ApiOperation(value = "查询选课")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Course> selectAll(){
        List<Course> courses = courseService.selectAll();

        return courses;
    }



    @ApiOperation(value = "选课")
    @ResponseBody
    @PostMapping("/concat")
    public ResultCode concat(@RequestParam("name")String name, @RequestParam("subject")String subject){
        courseService.concat(name,subject);

        return new ResultCode(200,"成功");
    }


    @ApiOperation(value = "我的选课")
    @ResponseBody
    @GetMapping("/selectMine")
    public List<Course> selectMine(@RequestParam("name")String name){

        return courseService.selectMine(name);
    }
}
