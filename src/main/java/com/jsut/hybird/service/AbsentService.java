package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Absent;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 19:59
 */

public interface AbsentService extends BaseService<Absent> {

    public List<Absent> selectByName(String name);

    List<Absent> selectByGrade(String grade);

    List<Absent> cancellationById(Integer id);
}
