package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Notice;
import com.jsut.hybird.pojo.Score;
import com.jsut.hybird.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
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


    @ResponseBody
    @GetMapping("/selectById")
    public Notice selectById(@RequestParam("id")Integer id){
        Notice notice = noticeService.selectById(id);
        return notice;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Notice> insert(Notice notice){
        List<Notice> notices = noticeService.insertT(notice);
        System.out.println(notice.toString());
        return notices;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Notice> selectAll(){
        List<Notice> notices = noticeService.selectAll();

        return notices;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Notice> updateById(Notice notice){
        List<Notice> notices = noticeService.updateById(notice);
        return notices;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Notice> deleteById(@RequestParam("id") Integer id){
        List<Notice> notices = noticeService.deleteById(id);

        return notices;
    }

    @ResponseBody
    @PutMapping("/updateY")
    public List<Notice> updateY(@RequestParam("id") Integer id){
        List<Notice> notices = noticeService.updateY(id);
        return notices;
    }
}
