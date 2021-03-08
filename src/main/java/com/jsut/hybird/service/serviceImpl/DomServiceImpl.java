package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.DomMapper;
import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.service.DomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 19:56
 */

@Service
public class DomServiceImpl implements DomService {

    @Autowired
    private DomMapper domMapper;

    @Override
    public List<Dom> selectAll() {

        return domMapper.selectAll();
    }

    @Override
    public Dom selectById(Integer id) {
        return domMapper.selectById(id);
    }

    @Override
    public List<Dom> deleteById(Integer id) {
        domMapper.deleteById(id);
        List<Dom> doms = domMapper.selectAll();
        return doms;
    }

    @Override
    public List<Dom> updateById(Dom dom) {
        domMapper.updateById(dom);
        List<Dom> doms = domMapper.selectAll();

        return doms;
    }

    @Override
    public List<Dom> insertT(Dom dom) {
        domMapper.insertT(dom);
        List<Dom> doms = domMapper.selectAll();

        return doms;
    }
}
