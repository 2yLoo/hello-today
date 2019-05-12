package com.yy.hellotoday.dto;

import com.yy.hellotoday.model.weather.Air;
import com.yy.hellotoday.model.weather.WeatherRise;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;

/**
 * 描述: 15天日出日，暂用于测试类
 *
 * @author 2yLoo
 * @create 2019-05-11 10:41
 */
@Document
public class Sunrise15Day implements Serializable {

    @Id
    private String id;
    /**
     * 空气质量
     */
    private Air air;
    /**
     * 日出日落
     */
    private Map<String, WeatherRise> rise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public Map<String, WeatherRise> getRise() {
        return rise;
    }

    public void setRise(Map<String, WeatherRise> rise) {
        this.rise = rise;
    }

    @Override
    public String toString() {
        return "Sunrise15Day{" +
                "id='" + id + '\'' +
                ", air=" + air +
                ", rise=" + rise +
                '}';
    }
}