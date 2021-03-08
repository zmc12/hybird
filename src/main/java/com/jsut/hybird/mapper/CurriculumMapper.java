package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Curriculum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 19:46
 */
@Mapper
public interface CurriculumMapper extends BaseMapper<Curriculum> {

    public Curriculum selectById(@Param("grade") String grade,@Param("term") String term);


}
