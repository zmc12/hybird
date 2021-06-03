package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.pojo.Course;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/5/25 12:58
 */
public interface CourseService extends BaseService<Course> {

    void concat(String name,String subject);

    List<Course> selectMine(String name);
}
