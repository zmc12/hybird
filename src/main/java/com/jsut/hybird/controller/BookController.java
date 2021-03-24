package com.jsut.hybird.controller;

import com.jsut.hybird.pojo.Book;
import com.jsut.hybird.pojo.Dom;
import com.jsut.hybird.pojo.ResultCode;
import com.jsut.hybird.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:12
 */
@Slf4j
@Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


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

    @ResponseBody
    @GetMapping("/selectById")
    public Book selectById(@RequestParam("id")Integer id){
        Book book = bookService.selectById(id);
        return book;
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Book> insert(Book book){
        List<Book> books = bookService.insertT(book);
        System.out.println(book.toString());
        return books;

    }

    @ResponseBody
    @GetMapping("/selectAll")
    public List<Book> selectAll(){
        List<Book> books = bookService.selectAll();

        return books;
    }

    @ResponseBody
    @PutMapping("/updateById")
    public List<Book> updateById(Book book){
        List<Book> books = bookService.updateById(book);
        return books;
    }


    @ResponseBody
    @DeleteMapping("/deleteById")
    public List<Book> deleteById(@RequestParam("id") Integer id){
        List<Book> books = bookService.deleteById(id);

        return books;
    }
}
