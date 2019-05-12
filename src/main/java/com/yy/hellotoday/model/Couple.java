package com.yy.hellotoday.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述: 这一天
 *
 * @author 2yLoo
 * @create 2019-05-09 17:22
 */
@Document
public class Couple implements Serializable {

    /**
     * 唯一主键
     */
    @Id
    private String id;
    /**
     * 你的邮箱，一夫一妻制
     */
    @Indexed(unique = true)
    private String yourEmail;
    /**
     * 我的邮箱，一夫一妻制
     */
    @Indexed(unique = true)
    private String myEmail;
    /**
     * 你的昵称
     */
    private String yourName;
    /**
     * 我的昵称
     */
    private String myName;
    /**
     * 妳的生日
     */
    private Date yourBirthday;
    /**
     * 我的生日
     */
    private Date myBirthday;
    /**
     * 第一天在一起
     */
    private Date together;
    /**
     * 结婚日期
     */
    private Date wedding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYourEmail() {
        return yourEmail;
    }

    public void setYourEmail(String yourEmail) {
        this.yourEmail = yourEmail;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Date getYourBirthday() {
        return yourBirthday;
    }

    public void setYourBirthday(Date yourBirthday) {
        this.yourBirthday = yourBirthday;
    }

    public Date getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(Date myBirthday) {
        this.myBirthday = myBirthday;
    }

    public Date getTogether() {
        return together;
    }

    public void setTogether(Date together) {
        this.together = together;
    }

    public Date getWedding() {
        return wedding;
    }

    public void setWedding(Date wedding) {
        this.wedding = wedding;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "id='" + id + '\'' +
                ", yourEmail='" + yourEmail + '\'' +
                ", myEmail='" + myEmail + '\'' +
                ", yourName='" + yourName + '\'' +
                ", myName='" + myName + '\'' +
                ", yourBirthday=" + yourBirthday +
                ", myBirthday=" + myBirthday +
                ", together=" + together +
                ", wedding=" + wedding +
                '}';
    }
}