package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Score;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:27
 */
public interface ScoreService extends BaseService<Score> {


    Score ifHas(Score score);

    List<Score> selectSubject();

    List<Score> selectByGrade(String grade, String subject);

    List<Score> selectByName(String name);
}
