package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.model.Couple;
import com.yy.hellotoday.repository.CoupleRepository;
import com.yy.hellotoday.service.CoupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述: 这一天服务实现类
 *
 * @author 2yLoo
 * @create 2019-05-09 18:54
 */
@Service
public class CoupleServiceImpl implements CoupleService {

    private CoupleRepository coupleRepository;

    @Autowired
    public CoupleServiceImpl(CoupleRepository coupleRepository) {
        this.coupleRepository = coupleRepository;
    }

    @Override
    public List<Couple> findAll() {
        return coupleRepository.findAll();
    }

}