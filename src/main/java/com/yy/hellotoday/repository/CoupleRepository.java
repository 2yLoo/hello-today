package com.yy.hellotoday.repository;

import com.yy.hellotoday.model.Couple;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述: 这一天Repository接口
 *
 * @author 2yLoo
 * @create 2019-05-09 17:27
 */
public interface CoupleRepository extends MongoRepository<Couple, String> {

    /**
     * 查找Couple
     *
     * @param myEmail 我的邮件
     * @return Couple
     */
    Couple findByMyEmail(String myEmail);
}