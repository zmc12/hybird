package com.jsut.hybird.mapper;


import com.jsut.hybird.pojo.Know;
import com.jsut.hybird.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/4/25 15:06
 */
@Mapper
@EnableAutoConfiguration
public interface KnowMapper {

    void insert(Know know);
    void deleteById(Integer id);

    void updateById(Know know);

    List<Know> selectStudent(@Param("id") Integer id);

    void updateY(Integer id);
}
