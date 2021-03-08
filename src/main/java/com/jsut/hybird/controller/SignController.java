package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.pojo.Sign;
import com.jsut.hybird.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:44
 */

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private SignService signService;

    @ResponseBody
    @GetMapping("/selectById")
    public Sign selectById(@RequestParam("id")Integer id){
        Sign sign = signService.selectById(id);
        return sign;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Sign> insert(Sign sign){
        System.out.println(sign.toString());
        List<Sign> signs = signService.insertT(sign);
        return signs;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Sign> selectAll(){
        List<Sign> signs = signService.selectAll();

        return signs;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Sign> updateById(Sign sign){
        List<Sign> signs = signService.updateById(sign);
        return signs;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Sign> deleteById(@RequestParam("id") Integer id){
        List<Sign> signs = signService.deleteById(id);

        return signs;
    }

    @ResponseBody
    @GetMapping("/selectSign")
    public List<Sign> selectSign(){
        List<Sign> signs = signService.selectSign();
        return signs;
    }

    @ResponseBody
    @GetMapping("/selectNoSign")
    public List<Sign> selectNoSign(){

        List<Sign> signs = signService.selectNoSign();
        return signs;
    }
}
