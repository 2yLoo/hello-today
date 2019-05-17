package com.yy.hellotoday.service;

import com.yy.hellotoday.model.One;

import java.io.IOException;

/**
 * 描述: 《一个》服务类接口
 *
 * @author 2yLoo
 * @create 2019-05-11 18:23
 */
public interface OneService {

    /**
     * 获取并保存《一个》数据
     *
     * @return 《一个》数据
     * @throws IOException IO异常 TODO: 2019-05-17 替换为异常体系
     */
    One getAndSaveOne() throws IOException;
}