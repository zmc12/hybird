package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Absent;
import com.jsut.hybird.service.BaseService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 19:58
 */

@Mapper
public interface AbsentMapper extends BaseMapper<Absent> {

    public List<Absent> selectByName(String name);

    List<Absent> selectByGrade(String grade);

    void cancellationById(Integer id);
}
