package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Dom;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 19:53
 */
public interface DomService extends BaseService<Dom> {

    List<Dom> selectByGrade(String grade, String term);
}
