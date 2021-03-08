package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Curriculum;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 19:41
 */
public interface CurriculumService extends BaseService<Curriculum> {


    public Curriculum selectById(String grade,String term);



}
