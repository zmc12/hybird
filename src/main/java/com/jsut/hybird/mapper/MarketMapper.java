package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Market;
import com.jsut.hybird.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:47
 */
@Mapper
public interface MarketMapper extends BaseMapper<Market> {

    List<Market> selectByUN(String userName);

}
