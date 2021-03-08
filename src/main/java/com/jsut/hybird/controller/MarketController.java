package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Book;
import com.jsut.hybird.pojo.Market;
import com.jsut.hybird.service.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:34
 */
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @ResponseBody
    @GetMapping("/selectById")
    public Market selectById(@RequestParam("id")Integer id){
        Market market = marketService.selectById(id);
        return market;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Market> insert(Market market){
        List<Market> markets = marketService.insertT(market);
        System.out.println(market.toString());
        return markets;
    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Market> selectAll(){
        List<Market> markets = marketService.selectAll();

        return markets;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Market> updateById(Market market){
        List<Market> markets = marketService.updateById(market);
        return markets;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Market> deleteById(@RequestParam("id") Integer id){
        List<Market> markets = marketService.deleteById(id);
        return markets;
    }

}
