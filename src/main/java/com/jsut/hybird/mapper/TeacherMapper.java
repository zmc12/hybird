package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:20
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    Teacher selectByUser(@Param("userName") String user,@Param("password") String password);
}
