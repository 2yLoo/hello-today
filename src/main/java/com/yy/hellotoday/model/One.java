package com.yy.hellotoday.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 描述: 《一个》实体类
 *
 * @author 2yLoo
 * @create 2019-05-11 18:23
 */
@Document
public class One implements Serializable {
    /**
     * Id
     */
    private String id;
    /**
     * 日期
     */
    // TODO: 2019-05-16 日期唯一
    @Indexed
    private String date;
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

    public One(String date, String image, String content) {
        this.date = date;
        this.image = image;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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