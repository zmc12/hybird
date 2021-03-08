package com.jsut.hybird.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:18
 */

@Mapper
public interface BaseMapper<T> {

    public List<T> selectAll();


    public T selectById(Integer id);

    public void deleteById(Integer id);

    public void updateById(T t);

    public void insertT(T t);

}
