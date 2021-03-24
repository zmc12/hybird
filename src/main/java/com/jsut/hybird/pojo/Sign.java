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
    private String location;
    private String method;
    private String stuation;
    private String temperature;

    private MultipartFile picture;

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", method='" + method + '\'' +
                ", stuation='" + stuation + '\'' +
                ", temperature='" + temperature + '\'' +
                ", picture=" + picture +
                '}';
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
