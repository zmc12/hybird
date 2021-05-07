package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Book;
import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.service.BookService;
import com.jsut.hybird.utils.Time;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:12
 */
@Api(value = "图书管理")
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @ApiOperation(value = "根据条形码查图书")
    @ResponseBody
    @PostMapping("/selectCode")
    public ResultCode selectCode(@RequestParam("code")String code){
        Book book = bookService.selectCode(code);
        if(book!=null){
            return new ResultCode(200,book.getBookName());
        }else {
            return new ResultCode(400,"识别失败");
        }

    }

    @ApiOperation(value = "根据id查图书")
    @ResponseBody
    @GetMapping("/selectById")
    public Book selectById(@RequestParam("id")Integer id){
        Book book = bookService.selectById(id);
        return book;
    }


    @ApiOperation(value = "插入图书")
    @ResponseBody
    @PostMapping("/insert")
    public List<Book> insert(Book book){
        List<Book> books = bookService.insertT(book);
        System.out.println(book.toString());
        return books;

    }

    @ApiOperation(value = "查询所有图书")
    @ResponseBody
    @GetMapping("/selectAll")
    public List<Book> selectAll(){
        List<Book> books = bookService.selectAll();

        return books;
    }

    @ApiOperation(value = "根据id更新图书")
    @ResponseBody
    @PutMapping("/updateById")
    public List<Book> updateById(Book book){
        System.out.println(book.toString());
        List<Book> books = bookService.updateById(book);
        return books;
    }


    @ApiOperation(value = "根据id删除图书")
    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Book> deleteById(@RequestParam("id") Integer id){
        List<Book> books = bookService.deleteById(id);

        return books;
    }



    @ApiOperation(value = "查借书人")
    @ResponseBody
    @GetMapping("/selectBroswer")
    public List<Book>  selectBroswer(@RequestParam("bookName")String bookName){

        List<Book> books=bookService.selectByName(bookName);
        return books;
    }


    @ApiOperation(value = "续期")
    @ResponseBody
    @PutMapping("/updateTime")
    public ResultCode updateTime(@RequestParam("bookName")String bookName,@RequestParam("studentName")String studentName,@RequestParam("time")String time){
        String newTime = new String();
        try {
            newTime = Time.subMonth(time);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        time=newTime;
        bookService.updateTime(bookName,studentName,time);
        return new ResultCode(200,"已续期一个月");

    }

}
