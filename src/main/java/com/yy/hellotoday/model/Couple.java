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
    private String urEmail;
    /**
     * 我的邮箱，一夫一妻制
     */
    @Indexed(unique = true)
    private String myEmail;
    /**
     * 你的省份
     */
    private String urProvince;
    /**
     * 你的市区
     */
    private String urCity;
    /**
     * 你的县区
     */
    private String urCounty;
    /**
     * 邮件标题
     */
    private String emailTitle;
    /**
     * 你的昵称
     */
    private String urName;
    /**
     * 我的昵称
     */
    private String myName;
    /**
     * 妳的生日
     */
    private String urBirthday;
    /**
     * 我的生日
     */
    private String myBirthday;
    /**
     * 第一天在一起
     */
    private String together;
    /**
     * 结婚日期
     */
    private String wedding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrEmail() {
        return urEmail;
    }

    public void setUrEmail(String urEmail) {
        this.urEmail = urEmail;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public String getUrProvince() {
        return urProvince;
    }

    public void setUrProvince(String urProvince) {
        this.urProvince = urProvince;
    }

    public String getUrCity() {
        return urCity;
    }

    public void setUrCity(String urCity) {
        this.urCity = urCity;
    }

    public String getUrCounty() {
        return urCounty;
    }

    public void setUrCounty(String urCounty) {
        this.urCounty = urCounty;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getUrBirthday() {
        return urBirthday;
    }

    public void setUrBirthday(String urBirthday) {
        this.urBirthday = urBirthday;
    }

    public String getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(String myBirthday) {
        this.myBirthday = myBirthday;
    }

    public String getTogether() {
        return together;
    }

    public void setTogether(String together) {
        this.together = together;
    }

    public String getWedding() {
        return wedding;
    }

    public void setWedding(String wedding) {
        this.wedding = wedding;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "id='" + id + '\'' +
                ", urEmail='" + urEmail + '\'' +
                ", myEmail='" + myEmail + '\'' +
                ", urProvince='" + urProvince + '\'' +
                ", urCity='" + urCity + '\'' +
                ", urCounty='" + urCounty + '\'' +
                ", emailTitle='" + emailTitle + '\'' +
                ", urName='" + urName + '\'' +
                ", myName='" + myName + '\'' +
                ", urBirthday='" + urBirthday + '\'' +
                ", myBirthday='" + myBirthday + '\'' +
                ", together='" + together + '\'' +
                ", wedding='" + wedding + '\'' +
                '}';
    }
}