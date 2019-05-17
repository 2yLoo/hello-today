package com.yy.hellotoday.service;

/**
 * 描述: 邮件服务接口
 *
 * @author 2yLoo
 * @create 2019-05-17 13:32
 */
public interface EmailService {

    /**
     * 发送今日邮件
     */
    void sendTodayMail();

    /**
     * 测试使用
     * <p>
     * TODO: 2019-05-17 移除测试
     */
    void test();
}