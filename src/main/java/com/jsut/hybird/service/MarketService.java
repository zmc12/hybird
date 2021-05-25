package com.jsut.hybird.service;

import com.jsut.hybird.pojo.Market;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:52
 */
public interface MarketService extends BaseService<Market> {
    List<Market> selectByUN(String userName);
}
