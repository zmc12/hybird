package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:18
 */
@EnableAutoConfiguration
@ApiModel(value = "成绩类")
public class Score implements Serializable {

    private Integer id;
    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "成绩")
    private Integer score;
    @ApiModelProperty(value = "课程")
    private String subject;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", subject='" + subject + '\'' +
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
