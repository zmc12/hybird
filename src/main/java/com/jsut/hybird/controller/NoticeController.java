package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.*;
import com.jsut.hybird.service.KnowService;
import com.jsut.hybird.service.NoticeService;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.utils.UserTeacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 18:46
 */


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

    @ResponseBody
    @PutMapping("/updateY")
    public List<Notice> updateY(@RequestParam("id") Integer id){
        List<Notice> notices = noticeService.updateY(id);
        return notices;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Notice> selectAll(){
        List<Notice> notices = noticeService.selectAll();

        return notices;
    }

    @ResponseBody
    @GetMapping("/selectById")
    public Notice selectById(@RequestParam("id")Integer id){
        Notice notice = noticeService.selectById(id);
        return notice;
    }


    @ResponseBody
    @GetMapping("/selectStudent")
    public List<Know> selectStudent(@RequestParam("id")Integer id){

        List<Know> knows = knowService.selectStudent(id);

        return knows;

    }

    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Notice> delete(@RequestParam("id")Integer id){
        List<Notice> notices = noticeService.deleteById(id);
        knowService.deleteById(id);
        return notices;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Notice> update(Notice notice){
        notice.setName(UserTeacher.Name);
        System.out.println(notice.toString());
        List<Notice> notices = noticeService.updateById(notice);


        return notices;
    }


    @ResponseBody
    @PostMapping("/insert")
    public List<Notice> insert(Notice notice){
        for(int i=0;i<notice.getGrades().length;i++){
            notice.setName(UserTeacher.Name);
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
