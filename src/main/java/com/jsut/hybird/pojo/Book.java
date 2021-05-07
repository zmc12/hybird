package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:08
 */
@EnableAutoConfiguration
@ApiModel(value = "图书类")
public class Book implements Serializable {

    private Integer id;
    @ApiModelProperty(value = "图书数量")
    private Integer amount;
    @ApiModelProperty(value = "书名")
    private String bookName;
    @ApiModelProperty(value = "借阅到期时间")
    private String time;
    @ApiModelProperty(value = "借书人姓名")
    private String studentName;
    @ApiModelProperty(value = "书码")
    private String code;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", amount=" + amount +
                ", bookName='" + bookName + '\'' +
                ", time='" + time + '\'' +
                ", studentName='" + studentName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
