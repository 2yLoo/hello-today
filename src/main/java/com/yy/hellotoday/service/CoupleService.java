package com.yy.hellotoday.service;

import com.yy.hellotoday.dto.TodayWeatherTipsDTO;
import com.yy.hellotoday.model.Couple;

import java.util.List;

/**
 * 描述: 这一天服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-09 18:54
 */
public interface CoupleService {

    Couple save(Couple couple);

    Couple findByMyEmail(String email);

    List<Couple> findAll();

    List<TodayWeatherTipsDTO> getTips(String us, String date);

}