package com.jsut.hybird.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.pojo.Score;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.service.ScoreService;
import com.jsut.hybird.service.StudentService;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:26
 */

@Api(value = "成绩管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StudentService studentService;


    @ApiOperation(value = "查询成绩")
    @ResponseBody
    @GetMapping("/selectById")
    public Score selectById(@RequestParam("id")Integer id){
        Score score = scoreService.selectById(id);
        return score;
    }


    @ApiOperation(value = "查询所有成绩")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Score> selectAll(){
        List<Score> scores = scoreService.selectAll();

        return scores;
    }

    @ApiOperation(value = "更新成绩")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Score> updateById(Score score){
        List<Score> scores = scoreService.updateById(score);
        return scores;
    }


    @ApiOperation(value = "删除成绩")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Score> deleteById(@RequestParam("id") Integer id){
        List<Score> scores = scoreService.deleteById(id);

        return scores;
    }

    @ApiOperation(value = "根据grade查询班级学生")
    @ResponseBody
    @GetMapping("/selectStudent")
    public List<Student> selectByGrade(@RequestParam("grade")String grade){

        List<Student> students=studentService.selectByGrade(grade);
        return students;
    }

    @ApiOperation(value = "新增成绩")
    @ResponseBody
    @PostMapping("/insert")
    public ResultCode insert(List<Score> scores)  {
        for(Score scoreList:scores){
            if(scoreService.ifHas(scoreList) == null){
                scoreService.insertT(scoreList);

            }else{
                scoreService.updateById(scoreList);
            }
        }

        return new ResultCode(200,"保存成绩成功");
    }


    @ApiOperation(value = "根据grade、subject查成绩")
    @ResponseBody
    @GetMapping("/selectScore")
    public List<Score> selectScore(@RequestParam("grade")String grade,@RequestParam("subject")String subject){

        List<Score> scores=scoreService.selectByGrade(grade,subject);
        return scores;
    }


    @ApiOperation(value = "查询所有课程")
    @ResponseBody
    @GetMapping("/selectSubject")
    public List<Score> selectScore(){

        List<Score> scoreList = scoreService.selectSubject();
        return scoreList;
    }

    @ApiOperation(value = "根据姓名查询成绩")
    @ResponseBody
    @GetMapping("/selectByName")
    public List<Score> selectByName(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        List<Score> scores = scoreService.selectByName(cookies[0].getValue());
        return scores;
    }
}
