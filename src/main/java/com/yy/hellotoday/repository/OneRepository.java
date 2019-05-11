package com.yy.hellotoday.repository;

import com.yy.hellotoday.model.One;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述: 《一个》Repository接口
 *
 * @author yangyang.luo
 * @create 2019-05-11 18:26
 */
public interface OneRepository extends MongoRepository<One, String> {
}