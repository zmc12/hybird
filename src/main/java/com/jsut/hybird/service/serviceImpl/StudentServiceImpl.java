package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.StudentMapper;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 16:56
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student selectById(Integer id) {
        Student student = studentMapper.selectById(id);
        return student;
    }

    @Override
    public List<Student> deleteById(Integer id) {

        studentMapper.deleteById(id);
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public List<Student> updateById(Student student) {
        studentMapper.updateById(student);
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public List<Student> insertT(Student student) {
        studentMapper.insertT(student);
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public Student selectByUser(String user, String password) {
        return studentMapper.selectByUser(user,password);
    }

    @Override
    public Student selectByNumber(String number) {
        return studentMapper.selectByNumber(number);
    }
}
