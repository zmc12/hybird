package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.service.AbsentService;
import com.jsut.hybird.utils.UserStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 20:16
 */

@Api(value = "请假管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;


    @ApiOperation(value = "根据id查成绩")
    @ResponseBody
    @GetMapping("/selectById")
    public Absent selectById(@RequestParam("id")Integer id){
         Absent absent=absentService.selectById(id);
        return absent;
    }

    @ApiOperation(value = "插入请假消息")
    @ResponseBody
    @PostMapping("/insert")
    public List<Absent> insert(Absent absent){
        System.out.println(absent.toString());
        List<Absent> absents = absentService.insertT(absent);
        return absents;
    }


    @ApiOperation(value = "查询所有请假消息")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Absent> selectAll(){
        List<Absent> absents = absentService.selectAll();

        return absents;
    }

    @ApiOperation(value ="审批请假")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Absent> updateById(Absent absent){
        List<Absent> absents = absentService.updateById(absent);
        return absents;
    }


    @ApiOperation(value = "根据id删除请假信息")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Absent> deleteById(@RequestParam("id") Integer id){
        List<Absent> absents = absentService.deleteById(id);

        return absents;
    }

    @ApiOperation(value = "根据学生姓名查请假信息")
    @ResponseBody
    @GetMapping("/selectByName")
    public List<Absent> selectByName(HttpSession session){

        String name =(String) session.getAttribute("name");
        List<Absent> absents = absentService.selectByName(UserStudent.Name);
        return absents;
    }


    @ApiOperation(value = "根据班级查请假消息")
    @ResponseBody
    @GetMapping("/selectByGrade")
    public List<Absent> select(@RequestParam("grade")String grade){
        List<Absent> absents = absentService.selectByGrade(grade);
        return absents;
    }


    @ApiOperation(value = "根据id批准销假")
    @ResponseBody
    @GetMapping("/cancellationById")
    public String cancellationById(@RequestParam("id")Integer id){
        absentService.cancellationById(id);
        return "操作成功";
    }


    @ApiOperation(value = "根据id发起销假")
    @ResponseBody
    @PostMapping("/postById")
    public List<Absent> postById(@RequestParam("id")Integer id){
        List<Absent> absents = absentService.postById(id);
        return absents;
    }
}
