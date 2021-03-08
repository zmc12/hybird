package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.TeacherMapper;
import com.jsut.hybird.pojo.Teacher;
import com.jsut.hybird.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:19
 */

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher selectById(Integer id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public List<Teacher> deleteById(Integer id) {

        teacherMapper.deleteById(id);
        List<Teacher> teachers = teacherMapper.selectAll();
        return teachers;
    }

    @Override
    public List<Teacher> updateById(Teacher teacher) {

        teacherMapper.updateById(teacher);
        List<Teacher> teachers = teacherMapper.selectAll();
        return teachers;
    }

    @Override
    public List<Teacher> insertT(Teacher teacher) {

        teacherMapper.insertT(teacher);
        List<Teacher> teachers = teacherMapper.selectAll();
        return teachers;
    }

    @Override
    public Teacher selectByUser(String user, String password) {
        return teacherMapper.selectByUser(user,password);
    }
}
