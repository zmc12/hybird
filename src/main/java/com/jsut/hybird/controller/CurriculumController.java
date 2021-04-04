package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Curriculum;
import com.jsut.hybird.service.CurriculumService;
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

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @ResponseBody
    @GetMapping("/selectById")
    public Curriculum selectById(@RequestParam("grade")String grade,@RequestParam("term")String term){
        Curriculum curriculum = curriculumService.selectById(grade,term);
        return curriculum;
    }

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

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Curriculum> selectAll(){
        List<Curriculum> curricula = curriculumService.selectAll();

        return curricula;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Curriculum> updateById(Curriculum curriculum){
        List<Curriculum> curricula = curriculumService.updateById(curriculum);
        return curricula;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Curriculum> deleteById(@RequestParam("id") Integer id){
        List<Curriculum> curricula = curriculumService.deleteById(id);

        return curricula;
    }

}
