package com.jsut.hybird.service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/2 12:06
 */
public interface BaseService<T> {


    public List<T> selectAll();


    public T selectById(Integer id);

    public List<T> deleteById(Integer id);

    public List<T> updateById(T t);

    public List<T> insertT(T t);
}
