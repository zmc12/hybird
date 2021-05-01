package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:32
 */
@Mapper
public interface SignMapper extends BaseMapper<Sign> {


    public List<Sign> selectSign();


    public List<Sign> selectNoSign();

    List<Sign> selectByGrade(@Param("grade") String grade,@Param("time") String time);
}
