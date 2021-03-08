package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Notice;
import com.jsut.hybird.pojo.Sign;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 15:09
 */
public interface NoticeService extends BaseService<Notice> {


    public List<Notice> updateY(Integer id);
}
