package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 20:26
 */
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {


    Score ifHas(Score score);

    List<Score> selectSubject();

    List<Score> selectByGrade(@Param("grade") String grade, @Param("subject") String subject);
}
