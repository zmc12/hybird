package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:12
 */
@EnableAutoConfiguration
@ApiModel(value = "宿舍类")
public class Dom implements Serializable {
    private Integer id;
    @ApiModelProperty(value = "宿舍号")
    private String number;
    @ApiModelProperty(value = "得分")
    private Integer score;
    @ApiModelProperty(value = "成员")
    private String students;

    @ApiModelProperty(value = "报修内容")
    private String fix;
    @ApiModelProperty(value = "报修进程")
    private String process;
    @ApiModelProperty(value = "班级")
    private String grade;
    @ApiModelProperty(value = "学期")
    private String term;


    @Override
    public String toString() {
        return "Dom{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", score=" + score +
                ", students='" + students + '\'' +
                ", fix='" + fix + '\'' +
                ", process='" + process + '\'' +
                ", grade='" + grade + '\'' +
                ", term='" + term + '\'' +
                '}';
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }
}
