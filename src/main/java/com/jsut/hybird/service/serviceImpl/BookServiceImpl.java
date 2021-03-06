package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.BookMapper;
import com.jsut.hybird.pojo.Book;
import com.jsut.hybird.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 12:09
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> deleteById(Integer id) {
        bookMapper.deleteById(id);

        return bookMapper.selectAll();
    }

    @Override
    public List<Book> updateById(Book book) {
        bookMapper.updateById(book);
        return bookMapper.selectAll();
    }

    @Override
    public List<Book> insertT(Book book) {
        bookMapper.insertT(book);
        return bookMapper.selectAll();
    }

    @Override
    public Book selectCode(String code) {
        return bookMapper.selectCode(code);
    }

    @Override
    public void updateTime(String bookName, String studentName, String time) {
        bookMapper.updateTime(bookName,studentName,time);
    }

    @Override
    public List<Book> selectByName(String bookName) {
        return bookMapper.selectByName(bookName);
    }

    @Override
    public void borrowBook(String bookName, String studentName, String time) {
        bookMapper.borrowBook(bookName,studentName,time);
    }

    @Override
    public List<Book> selectMine(String studentName) {
        return bookMapper.selectMine(studentName);
    }


}
