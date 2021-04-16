package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Dom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 19:52
 */

@Mapper
public interface DomMapper extends BaseMapper<Dom> {


    List<Dom> selectByGrade(@Param("grade") String grade, @Param("term") String term);
}
