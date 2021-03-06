package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Sign;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:31
 */
public interface SignService extends BaseService<Sign> {


    public List<Sign> selectSign();


    public List<Sign> selectNoSign();

    List<Sign> selectByGrade(String grade,String time);


    void insert1(Sign sign);


    List<String> selectTime();

    void updateById(Integer id);

    List<Sign> selectStudentNoSign(String name);

    List<Sign> selectStudentSign(String name);
}
