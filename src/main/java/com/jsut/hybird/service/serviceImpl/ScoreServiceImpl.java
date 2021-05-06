package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.ScoreMapper;
import com.jsut.hybird.pojo.Score;
import com.jsut.hybird.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:27
 */

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public Score selectById(Integer id) {
        return scoreMapper.selectById(id);
    }

    @Override
    public List<Score> deleteById(Integer id) {
        scoreMapper.deleteById(id);
        List<Score> scores = scoreMapper.selectAll();
        return scores;
    }

    @Override
    public List<Score> updateById(Score score) {
        scoreMapper.updateById(score);
        List<Score> scores = scoreMapper.selectAll();
        return scores;

    }

    @Override
    public List<Score> insertT(Score score) {
        scoreMapper.insertT(score);
        List<Score> scores = scoreMapper.selectAll();
        return scores;
    }


    @Override
    public Score ifHas(Score score) {
        Score scores = scoreMapper.ifHas(score);
        return scores;
    }

    @Override
    public List<Score> selectSubject() {
        return scoreMapper.selectSubject();
    }

    @Override
    public List<Score> selectByGrade(String grade, String subject) {
        return scoreMapper.selectByGrade(grade,subject);
    }
}
