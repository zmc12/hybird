package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.Score;
import com.jsut.hybird.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:26
 */
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @ResponseBody
    @GetMapping("/selectById")
    public Score selectById(@RequestParam("id")Integer id){
        Score score = scoreService.selectById(id);
        return score;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Score> insert(Score score){
        List<Score> scores = scoreService.insertT(score);
        System.out.println(score.toString());
        return scores;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Score> selectAll(){
        List<Score> scores = scoreService.selectAll();

        return scores;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Score> updateById(Score score){
        List<Score> scores = scoreService.updateById(score);
        return scores;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Score> deleteById(@RequestParam("id") Integer id){
        List<Score> scores = scoreService.deleteById(id);

        return scores;
    }
}
