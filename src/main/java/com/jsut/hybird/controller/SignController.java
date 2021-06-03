package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Know;
import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.pojo.Sign;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.service.BookService;
import com.jsut.hybird.service.SignService;
import com.jsut.hybird.service.StudentService;
import com.jsut.hybird.utils.Time;
import com.jsut.hybird.utils.ViapiFileUtilAdvance;
import com.jsut.hybird.utils.MultipartFileToFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/4 13:44
 */


@Api(value = "签到管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private SignService signService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookService bookService;




//    @ResponseBody
//    @PostMapping("/insertFace")
//    public ResultCode insertFace(Sign sign)  {
//        sign.setMethod("人脸识别");
//        sign.setStuation("已签到");
//        System.out.println(sign.toString());
//        MultipartFile picture = sign.getPicture();
//        if(picture==null){
//            return new ResultCode(400,"未识别到图像");
//        }
//
//        try {
//            File file = MultipartFileToFile.multipartFileToFile(picture);
//            String read = ViapiFileUtilAdvance.read(new FileInputStream(file));
//            String[] str=read.split(",");
//            String newRead = new String();
//            for(int i=16;i<str.length-1;i++){
//                if(i!=str.length-2){
//                    newRead += str[i]+",";
//                }else {
//                    newRead += str[i]+"}";
//                }
//
//            }
//            System.out.println(newRead);
//            List<Sign> signs = signService.insertT(sign);
//            return new ResultCode(200, newRead);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResultCode(400,"识别失败");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResultCode(400,"识别失败");
//        }
//    }



//    @ApiOperation(value = "查询所有签到")
//    @ResponseBody
//    @GetMapping("/selectAll")
//    public List<Sign> selectAll(){
//        List<Sign> signs = signService.selectAll();
//
//        return signs;
//    }

//    @ApiOperation(value = "更新签到")
//    @ResponseBody
//    @PutMapping("/updateById")
//    public List<Sign> updateById(Sign sign){
//        List<Sign> signs = signService.updateById(sign);
//        return signs;
//    }


//    @ApiOperation(value = "删除签到")
//    @ResponseBody
//    @DeleteMapping("/deleteById")
//    public List<Sign> deleteById(@RequestParam("id") Integer id){
//        List<Sign> signs = signService.deleteById(id);
//
//        return signs;
//    }

//    @ApiOperation(value = "查询已签到")
//    @ResponseBody
//    @GetMapping("/selectSign")
//    public List<Sign> selectSign(){
//        List<Sign> signs = signService.selectSign();
//        return signs;
//    }
//
//    @ApiOperation(value = "查询未签到")
//    @ResponseBody
//    @GetMapping("/selectNoSign")
//    public List<Sign> selectNoSign(){
//
//        List<Sign> signs = signService.selectNoSign();
//        return signs;
//    }



    @ApiOperation(value = "查询签到")
    @ResponseBody
    @GetMapping("/selectById")
    public Sign selectById(@RequestParam("id")Integer id){
        Sign sign = signService.selectById(id);
        return sign;
    }

    @ResponseBody
    @PostMapping("/insertFinger")
    public ResultCode insertFinger(Sign sign){
        sign.setMethod("指纹签到");
        sign.setStuation("已签到");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        sign.setTime(df.format(new Date()));
        Student student = studentService.selectByNumber(sign.getName());
        sign.setName(student.getName());
        List<Sign> signs = signService.insertT(sign);
        return new ResultCode(200,student.getName()+" sign success");

    }

    @ApiOperation(value = "学生签到")
    @ResponseBody
    @PostMapping("/studentSign")
    public ResultCode studentSign(@RequestParam("id")Integer id){
        signService.updateById(id);
        return new ResultCode(200,"签到成功");

    }


    @ApiOperation(value = "根据grade、time查询签到信息")
    @ResponseBody
    @GetMapping("/selectByGrade")
    public List<Sign> select(@RequestParam("grade")String grade,@RequestParam("time")String time){
        List<Sign> signs = signService.selectByGrade(grade, time);

        return signs;
    }

    @ApiOperation(value = "发起签到")
    @ResponseBody
    @PostMapping("/insert1")
    public ResultCode insert1(Sign sign,@RequestParam(value = "grade",required = false)String grade){
        String time = Time.dateToString2(new Date());
        //Sign sign = new Sign();
        sign.setTime(time);
        //sign.setMethod(method);
        sign.setStuation("未签到");
        List<Student> students = studentService.selectAll();
        for(int i=0;i<students.size();i++){
            sign.setName(students.get(i).getName());
            signService.insert1(sign);
        }
        return new ResultCode(200,"发起成功");
    }

    @ApiOperation(value = "查询签到时间")
    @ResponseBody
    @GetMapping("/selectTime")
    public List<String> selectTime(Sign sign){
        List<String> signs = signService.selectTime();
        return signs;
    }


    @ApiOperation(value = "查询学生未签到")
    @ResponseBody
    @GetMapping("/selectStudentNoSign")
    public List<Sign> selectStudentNoSign(@RequestParam("name")String name){
        List<Sign> signs = signService.selectStudentNoSign(name);
        return signs;
    }


    @ApiOperation(value = "查询学生已签到")
    @ResponseBody
    @GetMapping("/selectStudentSign")
    public List<Sign> selectStudentSign(@RequestParam("name")String name){
        List<Sign> signs = signService.selectStudentSign(name);
        return signs;
    }
}
