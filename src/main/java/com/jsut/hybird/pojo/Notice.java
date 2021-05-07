package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:16
 */
@EnableAutoConfiguration
@ApiModel(value = "通知类")
public class Notice implements Serializable {

    private Integer id;
    @ApiModelProperty(value = "通知内容")
    private String text;
    @ApiModelProperty(hidden = true)
    private String grade;
    @ApiModelProperty(value = "发布人姓名")
    private String name;
    @ApiModelProperty(value = "通知标题")
    private String title;

    @ApiModelProperty(value = "接收班级")
    private String[] grades;

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getGrades() {
        return grades;
    }

    public void setGrades(String[] grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
