package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Student;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 16:55
 */
public interface StudentService extends BaseService<Student> {
    Student selectByUser(String user, String password);
}
