package com.yy.hellotoday.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 描述: 《一个》实体类
 *
 * @author yangyang.luo
 * @create 2019-05-11 18:23
 */
@Document
public class One implements Serializable {
    /**
     * Id
     */
    private String id;
    /**
     * 图片地址
     */
    private String image;
    /**
     * 短句内容
     */
    private String content;

    public One() {
    }

    public One(String id, String image, String content) {
        this.id = id;
        this.image = image;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "One{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}