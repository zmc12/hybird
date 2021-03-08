package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.MarketMapper;
import com.jsut.hybird.pojo.Market;
import com.jsut.hybird.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:52
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketMapper marketMapper;

    @Override
    public List<Market> selectAll() {
        List<Market> markets = marketMapper.selectAll();
        return markets;
    }

    @Override
    public Market selectById(Integer id) {
        Market market = marketMapper.selectById(id);
        return market;
    }

    @Override
    public List<Market> deleteById(Integer id) {
        marketMapper.deleteById(id);
        List<Market> markets = marketMapper.selectAll();
        return markets;
    }

    @Override
    public List<Market> updateById(Market market) {
        marketMapper.updateById(market);
        List<Market> markets = marketMapper.selectAll();
        return markets;
    }

    @Override
    public List<Market> insertT(Market market) {
        marketMapper.insertT(market);
        List<Market> markets = marketMapper.selectAll();
        return markets;
    }
}
