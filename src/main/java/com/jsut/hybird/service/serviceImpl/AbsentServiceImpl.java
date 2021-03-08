package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.AbsentMapper;
import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.service.AbsentService;
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
        return absentMapper.selectAll();
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
}
