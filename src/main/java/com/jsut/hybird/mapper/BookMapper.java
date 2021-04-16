package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:08
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    public Book selectCode(String code);


    void updateTime(@Param("bookName") String bookName, @Param("studentName") String studentName, @Param("time") String time);


    List<Book> selectByName(String bookName);
}
