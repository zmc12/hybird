package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 16:54
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    Student selectByUser(@Param("userName") String user,@Param("password") String password);

    public Student selectByNumber(String number);
}
