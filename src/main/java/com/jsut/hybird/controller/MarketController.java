package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Book;
import com.jsut.hybird.pojo.Market;
import com.jsut.hybird.service.MarketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:34
 */

@Api(value = "跳蚤市场管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;


    @ApiOperation(value = "查询交易信息")
    @ResponseBody
    @GetMapping("/selectById")
    public Market selectById(@RequestParam("id")Integer id){
        Market market = marketService.selectById(id);
        return market;
    }

    @ApiOperation(value = "新增交易信息")
    @ResponseBody
    @PostMapping("/insert")
    public List<Market> insert(Market market) throws IOException {
        MultipartFile imgFile = market.getFile();
        if(market.getFile()!=null){
            // 拿到文件名
            String filename = imgFile.getOriginalFilename();

            //String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
//        // 存放上传图片的文件夹
//        File fileDir = UploadUtils.getImgDirFile();
//        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
//        System.out.println(fileDir.getAbsolutePath());

            // 构建真实的文件路径
            File newFile = new File("/opt/pics"+ File.separator + filename);
            System.out.println(newFile.getAbsolutePath());

            try {


                // 上传图片到 -》 “绝对路径”
                imgFile.transferTo(newFile);
                market.setPath(filename);


            } catch (IOException e) {


                e.printStackTrace();
            }


        }



        List<Market> markets = marketService.insertT(market);

        return markets;
    }

    @ApiOperation(value = "查询所有交易信息")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Market> selectAll(){
        List<Market> markets = marketService.selectAll();

        return markets;
    }

    @ApiOperation (value = "更新交易信息")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Market> updateById(Market market){
        List<Market> markets = marketService.updateById(market);
        return markets;
    }


    @ApiOperation(value = "删除交易信息")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Market> deleteById(@RequestParam("id") Integer id){
        List<Market> markets = marketService.deleteById(id);
        return markets;
    }


    @ApiOperation(value = "根据学号查询发布信息")
    @ResponseBody
    @GetMapping("/selectByUN")
    public List<Market> selectByUN(@RequestParam("userName") String userName){
        List<Market> markets = marketService.selectByUN(userName);
        return markets;
    }
}
