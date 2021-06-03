package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.CourseMapper;
import com.jsut.hybird.pojo.Course;
import com.jsut.hybird.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/5/25 12:58
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public Course selectById(Integer id) {
        return null;
    }

    @Override
    public List<Course> deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Course> updateById(Course course) {
        return null;
    }

    @Override
    public List<Course> insertT(Course course) {
        return null;
    }

    @Override
    public void concat(String name,String subject) {
        courseMapper.concat(name,subject);
    }

    @Override
    public List<Course> selectMine(String name) {
        return courseMapper.selectMine(name);
    }
}
