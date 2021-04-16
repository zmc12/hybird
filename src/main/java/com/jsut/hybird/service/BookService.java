package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:09
 */
public interface BookService extends BaseService<Book> {


    public Book selectCode(String code);


    void updateTime(String bookName,  String studentName,String time);


    List<Book> selectByName(String bookName);
}
