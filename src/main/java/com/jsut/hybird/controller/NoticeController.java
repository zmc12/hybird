package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.*;
import com.jsut.hybird.service.KnowService;
import com.jsut.hybird.service.NoticeService;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.utils.UserTeacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 18:46
 */

@Api(value = "通知管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    @Autowired
    private KnowService knowService;

    @Autowired
    private StudentService studentService;



//    @ResponseBody
//    @PostMapping("/insert")
//    public List<Notice> insert(Notice notice){
//        List<Notice> notices = noticeService.insertT(notice);
//        System.out.println(notice.toString());
//        return notices;
//    }



//    @ResponseBody
//    @PutMapping("/updateById")
//    public List<Notice> updateById(Notice notice){
//        List<Notice> notices = noticeService.updateById(notice);
//        return notices;
//    }
//
//
//    @ResponseBody
//    @DeleteMapping("/deleteById")
//    public List<Notice> deleteById(@RequestParam("id") Integer id){
//        List<Notice> notices = noticeService.deleteById(id);
//
//        return notices;
//    }

    @ApiOperation(value = "确认通知")
    @ResponseBody
    @PutMapping("/updateY")
    public List<Notice> updateY(@RequestParam("id") Integer id){
        List<Notice> notices = noticeService.updateY(id);
        return notices;
    }

    @ApiOperation(value = "查询所有通知")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Notice> selectAll(){
        List<Notice> notices = noticeService.selectAll();

        return notices;
    }

    @ApiOperation(value = "查询通知")
    @ResponseBody
    @GetMapping("/selectById")
    public Notice selectById(@RequestParam("id")Integer id){
        Notice notice = noticeService.selectById(id);
        return notice;
    }


    @ApiOperation(value = "查询未签到学生")
    @ResponseBody
    @GetMapping("/selectStudent")
    public List<Know> selectStudent(@RequestParam("id")Integer id){

        List<Know> knows = knowService.selectStudent(id);

        return knows;

    }

    @ApiOperation(value = "删除通知")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Notice> delete(@RequestParam("id")Integer id){
        List<Notice> notices = noticeService.deleteById(id);
        knowService.deleteById(id);
        return notices;
    }

    @ApiOperation(value = "更新通知")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Notice> update(Notice notice, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        notice.setName(cookies[0].getValue());
        System.out.println(notice.toString());
        List<Notice> notices = noticeService.updateById(notice);


        return notices;
    }


    @ApiOperation(value = "新增通知")
    @ResponseBody
    @PostMapping("/insert")
    public List<Notice> insert(Notice notice,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<notice.getGrades().length;i++){
            notice.setName(cookies[0].getValue());
            notice.setGrade(notice.getGrades()[i]);
            noticeService.insertT(notice);
            Integer id = notice.getId();
            List<Student> students = studentService.selectByGrade(notice.getGrade());
            for(int j=0;j<students.size();j++){
                knowService.insert(new Know(id,students.get(j).getName(),"未确认"));
            }
        }

        List<Notice> notices = noticeService.selectAll();
        return notices;
    }
}
