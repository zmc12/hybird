package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Student;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 16:55
 */
public interface StudentService extends BaseService<Student> {
    Student selectByUser(String user, String password);


    public Student selectByNumber(String number);

    List<Student> selectByGrade(String grade);

    String selectByName(String name);
}
