package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:00
 */
@EnableAutoConfiguration
@ApiModel(value = "请假类")
public class Absent implements Serializable {


    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "请假理由")
    private String reason;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "接收时间")
    private String endTime;
    @ApiModelProperty(value = "审批结果")
    private String result;
    @ApiModelProperty(value = "教师批复")
    private String reply;

    @Override
    public String toString() {
        return "Absent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", result='" + result + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
