package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.AbsentMapper;
import com.jsut.hybird.mapper.StudentMapper;
import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.service.AbsentService;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.utils.UserStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 19:59
 */

@Service
public class AbsentServiceImpl implements AbsentService {
    @Autowired
    private AbsentMapper absentMapper;


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Absent> selectAll() {
        return absentMapper.selectAll();
    }

    @Override
    public Absent selectById(Integer id) {

        return absentMapper.selectById(id);
    }

    @Override
    public List<Absent> deleteById(Integer id) {
        absentMapper.deleteById(id);
        return absentMapper.selectAll();
    }

    @Override
    public List<Absent> updateById(Absent absent) {
        absentMapper.updateById(absent);
        String grade = studentMapper.selectByName(absent.getName());
        List<Absent> absents = absentMapper.selectByGrade(grade);
        return absents;
    }

    @Override
    public List<Absent> insertT(Absent absent) {
        absentMapper.insertT(absent);
        List<Absent> absents = absentMapper.selectAll();
        return absents;
    }

    @Override
    public List<Absent> selectByName(String name) {
        return absentMapper.selectByName(name);
    }

    @Override
    public List<Absent> selectByGrade(String grade) {
        return absentMapper.selectByGrade(grade);
    }

    @Override
    public List<Absent> cancellationById(Integer id) {
        absentMapper.cancellationById(id);
        List<Absent> absents = absentMapper.selectByName(UserStudent.Name);
        return absents;
    }
}
