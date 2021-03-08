package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.CurriculumMapper;
import com.jsut.hybird.pojo.Curriculum;
import com.jsut.hybird.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 19:47
 */

@Service
public class CurriculumServiceImpl implements CurriculumService {
    @Autowired
    private CurriculumMapper curriculumMapper;


    @Override
    public Curriculum selectById(String grade, String term) {
        return curriculumMapper.selectById(grade,term);
    }

    @Override
    public List<Curriculum> selectAll() {
        return curriculumMapper.selectAll();
    }

    @Override
    public Curriculum selectById(Integer id) {
        return null;
    }


    @Override
    public List<Curriculum> deleteById(Integer id) {
        curriculumMapper.deleteById(id);
        return curriculumMapper.selectAll();
    }

    @Override
    public List<Curriculum> updateById(Curriculum curriculum) {
        curriculumMapper.updateById(curriculum);
        return curriculumMapper.selectAll();
    }

    @Override
    public List<Curriculum> insertT(Curriculum curriculum) {
        curriculumMapper.insertT(curriculum);
        return curriculumMapper.selectAll();
    }
}
