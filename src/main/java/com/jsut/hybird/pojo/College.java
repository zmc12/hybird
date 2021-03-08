package com.jsut.hybird.pojo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/1/23 12:05
 */
@EnableAutoConfiguration

public class College implements Serializable {
    private Integer id;
    private String college;
    private String grade;

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
