package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.service.AbsentService;
import com.jsut.hybird.utils.UserStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 20:16
 */

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;


    @ResponseBody
    @GetMapping("/selectById")
    public Absent selectById(@RequestParam("id")Integer id){
         Absent absent=absentService.selectById(id);
        return absent;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Absent> insert(Absent absent){
        System.out.println(absent.toString());
        List<Absent> absents = absentService.insertT(absent);
        return absents;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Absent> selectAll(){
        List<Absent> absents = absentService.selectAll();

        return absents;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Absent> updateById(Absent absent){
        List<Absent> absents = absentService.updateById(absent);
        return absents;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Absent> deleteById(@RequestParam("id") Integer id){
        List<Absent> absents = absentService.deleteById(id);

        return absents;
    }

    @ResponseBody
    @GetMapping("/selectByName")
    public List<Absent> selectByName(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        List<Absent> absents = absentService.selectByName(cookies[0].getValue());
        return absents;
    }

    @ResponseBody
    @GetMapping("/selectByGrade")
    public List<Absent> select(@RequestParam("grade")String grade){
        List<Absent> absents = absentService.selectByGrade(grade);
        return absents;
    }
}
