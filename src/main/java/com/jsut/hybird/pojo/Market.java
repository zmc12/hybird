package com.jsut.hybird.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author ZhangMinCong
 * @date 2021/1/20 16:15
 */
@EnableAutoConfiguration
@ApiModel(value = "交易市场类")
public class Market implements Serializable {

    private Integer id;
    @ApiModelProperty(value = "物品信息")
    private String text;
    @ApiModelProperty(value = "联系方式")
    private String contact;
    @ApiModelProperty(value = "物品图片")
    private MultipartFile file;
    @ApiModelProperty(hidden = true)
    private String path;

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", contact='" + contact + '\'' +
                ", file=" + file +
                ", path='" + path + '\'' +
                '}';
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
}
