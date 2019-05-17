package com.yy.hellotoday.service;

import com.yy.hellotoday.model.Couple;

import java.util.List;

/**
 * 描述: CP服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-09 18:54
 */
public interface CoupleService {

    /**
     * 获取所有CP
     *
     * @return CP列表
     */
    List<Couple> findAll();

}