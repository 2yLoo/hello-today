package com.yy.hellotoday.service;

import com.yy.hellotoday.model.One;

import java.io.IOException;

/**
 * 描述: 《一个》服务类接口
 *
 * @author yangyang.luo
 * @create 2019-05-11 18:23
 */
public interface OneService {

    One saveOne() throws IOException;

    One getOne(String date);
}