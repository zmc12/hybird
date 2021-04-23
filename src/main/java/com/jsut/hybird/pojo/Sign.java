package com.jsut.hybird.pojo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:20
 */
@EnableAutoConfiguration
public class Sign implements Serializable {

    private Integer id;
    private String name;
    //private String location;
    private String method;
    private String stuation;
    private String temperature;


    private String smoke;
    private String fire;
    private String wet;
    private String time;

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", stuation='" + stuation + '\'' +
                ", temperature='" + temperature + '\'' +
                ", smoke='" + smoke + '\'' +
                ", fire='" + fire + '\'' +
                ", wet='" + wet + '\'' +
                ", time='" + time + '\'' +
                ", picture=" + picture +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private MultipartFile picture;

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }


    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire;
    }

    public String getWet() {
        return wet;
    }

    public void setWet(String wet) {
        this.wet = wet;
    }



    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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



    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStuation() {
        return stuation;
    }

    public void setStuation(String stuation) {
        this.stuation = stuation;
    }
}
