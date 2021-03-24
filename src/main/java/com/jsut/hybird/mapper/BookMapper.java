package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:08
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    public Book selectCode(String code);
}
