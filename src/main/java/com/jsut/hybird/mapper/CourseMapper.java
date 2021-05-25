package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/5/25 12:56
 */

@Mapper
public interface CourseMapper extends BaseMapper<Course> {


    void concat(@Param("name") String name,@Param("subject") String subject);
}
