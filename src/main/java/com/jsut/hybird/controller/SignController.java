package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.pojo.Sign;
import com.jsut.hybird.service.SignService;
import com.jsut.hybird.utils.ViapiFileUtilAdvance;
import com.jsut.hybird.utils.MultipartFileToFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:44
 */

@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private SignService signService;

    @ResponseBody
    @GetMapping("/selectById")
    public Sign selectById(@RequestParam("id")Integer id){
        Sign sign = signService.selectById(id);
        return sign;
    }

    @ResponseBody
    @PostMapping("/insertFace")
    public ResultCode insertFace(Sign sign)  {
        sign.setMethod("人脸识别");
        sign.setStuation("已签到");
        System.out.println(sign.toString());
        MultipartFile picture = sign.getPicture();
        if(picture==null){
            return new ResultCode(400,"未识别到图像");
        }

        try {
            File file = MultipartFileToFile.multipartFileToFile(picture);
            String read = ViapiFileUtilAdvance.read(new FileInputStream(file));
            String[] str=read.split(",");
            String newRead = new String();
            for(int i=16;i<str.length-1;i++){
                if(i!=str.length-2){
                    newRead += str[i]+",";
                }else {
                    newRead += str[i]+"}";
                }

            }
            System.out.println(newRead);
            List<Sign> signs = signService.insertT(sign);
            return new ResultCode(200, newRead);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultCode(400,"识别失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultCode(400,"识别失败");
        }


    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Sign> insert(Sign sign){
        sign.setStuation("已签到");
        List<Sign> signs = signService.insertT(sign);
        System.out.println(signs.toString());
        return signs;

    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Sign> selectAll(){
        List<Sign> signs = signService.selectAll();

        return signs;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Sign> updateById(Sign sign){
        List<Sign> signs = signService.updateById(sign);
        return signs;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Sign> deleteById(@RequestParam("id") Integer id){
        List<Sign> signs = signService.deleteById(id);

        return signs;
    }

    @ResponseBody
    @GetMapping("/selectSign")
    public List<Sign> selectSign(){
        List<Sign> signs = signService.selectSign();
        return signs;
    }

    @ResponseBody
    @GetMapping("/selectNoSign")
    public List<Sign> selectNoSign(){

        List<Sign> signs = signService.selectNoSign();
        return signs;
    }
}
