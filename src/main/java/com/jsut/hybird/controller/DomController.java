package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.service.DomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:05
 */

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/dom")
public class DomController {

    @Autowired
    private DomService domService;


    @ResponseBody
    @GetMapping("/selectById")
    public Dom selectById(@RequestParam("id")Integer id){
        Dom dom = domService.selectById(id);
        return dom;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Dom> insert(Dom dom){
        List<Dom> doms = domService.insertT(dom);
        System.out.println(dom.toString());
        return doms;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Dom> selectAll(){
        List<Dom> doms = domService.selectAll();

        return doms;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Dom> updateById(Dom dom){
        List<Dom> doms = domService.updateById(dom);
        return doms;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Dom> deleteById(@RequestParam("id") Integer id){
        List<Dom> doms = domService.deleteById(id);

        return doms;
    }


    @ResponseBody
    @GetMapping("/selectByGrade")
    public List<Dom> selectByGrade(@RequestParam("grade")String grade,@RequestParam("term")String term){
        List<Dom> doms = domService.selectByGrade(grade, term);
        return doms;
    }
}
