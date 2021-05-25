package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/5/25 12:45
 */

@EnableAutoConfiguration
@ApiModel(value = "选课类")
public class Course {

    private Integer id;
    private String names;
    private String subject;
    private String name;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                '}';
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
