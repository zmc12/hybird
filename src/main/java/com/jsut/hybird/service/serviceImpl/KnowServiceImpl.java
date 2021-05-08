package com.jsut.hybird.service.serviceImpl;


import com.jsut.hybird.mapper.KnowMapper;
import com.jsut.hybird.pojo.Know;
import com.jsut.hybird.pojo.Notice;
import com.jsut.hybird.service.KnowService;
import com.jsut.hybird.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/4/25 15:07
 */
@Service
public class KnowServiceImpl implements KnowService {

    @Autowired
    private KnowMapper knowMapper;

    @Autowired
    private NoticeService noticeService;

    @Override
    public void insert(Know know) {
        knowMapper.insert(know);
    }

    @Override
    public void deleteById(Integer id) {
        knowMapper.deleteById(id);
    }

    @Override
    public void updateById(Know know) {

        knowMapper.updateById(know);
    }

    @Override
    public List<Know> selectStudent(Integer id) {
        return knowMapper.selectStudent(id);
    }

    @Override
    public void updateY(Integer id) {
        knowMapper.updateY(id);
    }


}
