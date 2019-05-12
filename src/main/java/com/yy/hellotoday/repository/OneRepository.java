package com.yy.hellotoday.repository;

import com.yy.hellotoday.model.One;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述: 《一个》Repository接口
 *
 * @author 2yLoo
 * @create 2019-05-11 18:26
 */
public interface OneRepository extends MongoRepository<One, String> {

    /**
     * 根据ID获取《一个》信息
     *
     * @param id id
     * @return 《一个》信息
     */
    One findOneByIdIs(String id);
}