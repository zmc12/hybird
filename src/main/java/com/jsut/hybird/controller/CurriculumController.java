package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Curriculum;
import com.jsut.hybird.service.CurriculumService;
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
 * @Date: 2021/3/4 19:55
 */

@Api(value = "课程表管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @ApiOperation(value = "根据term、grade选择课程表")
    @ResponseBody
    @GetMapping("/selectById")
    public Curriculum selectById(@RequestParam("grade")String grade,@RequestParam("term")String term){
        Curriculum curriculum = curriculumService.selectById(grade,term);
        return curriculum;
    }

    @ApiOperation(value = "插入课程表")
    @ResponseBody
    @PostMapping("/insert")
    public List<Curriculum> insert(Curriculum curriculum){
        System.out.println(curriculum.toString());
        if(curriculumService.selectById(curriculum.getGrade(),curriculum.getTerm())==null){
            List<Curriculum> curricula1 = curriculumService.insertT(curriculum);
            return curricula1;
        }else {
            List<Curriculum> curricula2 = curriculumService.updateById(curriculum);
            return curricula2;
        }

    }

    @ApiOperation(value = "查询所有课程表")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Curriculum> selectAll(){
        List<Curriculum> curricula = curriculumService.selectAll();

        return curricula;
    }


    @ApiOperation(value = "更新课程表")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Curriculum> updateById(Curriculum curriculum){
        List<Curriculum> curricula = curriculumService.updateById(curriculum);
        return curricula;
    }


    @ApiOperation(value = "删除课程表")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Curriculum> deleteById(@RequestParam("id") Integer id){
        List<Curriculum> curricula = curriculumService.deleteById(id);

        return curricula;
    }

}
