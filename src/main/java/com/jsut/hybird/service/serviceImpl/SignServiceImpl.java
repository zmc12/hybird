package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.SignMapper;
import com.jsut.hybird.pojo.Sign;
import com.jsut.hybird.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:40
 */

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public List<Sign> selectAll() {
        return signMapper.selectAll();
    }

    @Override
    public Sign selectById(Integer id) {
        return signMapper.selectById(id);
    }

    @Override
    public List<Sign> deleteById(Integer id) {
        signMapper.deleteById(id);
        return signMapper.selectAll();
    }

    @Override
    public List<Sign> updateById(Sign sign) {
        signMapper.updateById(sign);
        return signMapper.selectAll();
    }

    @Override
    public List<Sign> insertT(Sign sign) {
        signMapper.insertT(sign);
        return signMapper.selectAll();
    }

    @Override
    public List<Sign> selectSign() {
        return signMapper.selectSign();
    }

    @Override
    public List<Sign> selectNoSign() {
        return signMapper.selectNoSign();
    }

    @Override
    public List<Sign> selectByGrade(String grade, String time) {
        return signMapper.selectByGrade(grade,time);
    }

    @Override
    public void insert1(Sign sign) {
        signMapper.insert1(sign);
    }


}
