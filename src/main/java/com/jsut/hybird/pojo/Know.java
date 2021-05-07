package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/4/25 15:09
 */
@EnableAutoConfiguration
@ApiModel(value = "未接收通知类")
public class Know implements Serializable {

    private Integer id;
    @ApiModelProperty(hidden = true)
    private Integer nid;
    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "接收状态")
    private String situation;

    public Know() {
    }

    public Know(Integer nid, String name, String situation) {
        this.nid = nid;
        this.name = name;
        this.situation = situation;
    }

    public Know(Integer id, Integer nid, String name, String situation) {
        this.id = id;
        this.nid = nid;
        this.name = name;
        this.situation = situation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Know{" +
                "id=" + id +
                ", nid=" + nid +
                ", name='" + name + '\'' +
                ", situation='" + situation + '\'' +
                '}';
    }
}
