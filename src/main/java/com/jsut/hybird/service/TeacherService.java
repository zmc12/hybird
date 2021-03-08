package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Teacher;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:19
 */
public interface TeacherService extends BaseService<Teacher> {
    Teacher selectByUser(String user, String password);
}
