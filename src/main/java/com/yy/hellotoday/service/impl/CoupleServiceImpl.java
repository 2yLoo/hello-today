package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.dto.TodayWeatherTipsDTO;
import com.yy.hellotoday.model.Couple;
import com.yy.hellotoday.repository.CoupleRepository;
import com.yy.hellotoday.service.CoupleService;
import com.yy.hellotoday.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public Couple save(Couple couple){
        return coupleRepository.save(couple);
    }

    @Override
    public Couple findByMyEmail(String email){
        return coupleRepository.findByMyEmail(email);
    }

    @Override
    public List<Couple> findAll() {
        return coupleRepository.findAll();
    }

    @Override
    public List<TodayWeatherTipsDTO> getTips(String us, String date){
        List<TodayWeatherTipsDTO> tips = new ArrayList<>();

        return tips;
    }

    private String getYourBirthdayTip(Date birthday){
        String tip = null;
        int dayNum = DateUtil.daysPerYearBetween(new Date(), birthday);
        if (dayNum<10 && dayNum>0){
            tip = "距离小可爱的生日还有"+dayNum+"天！";
        }else if (dayNum == 0){
            tip = "Happy Birthday To My Little Princess！";
        }
        return tip;
    }

    private String getMyBirthdayTip(Date birthday){
        String tip = null;
        int dayNum = DateUtil.daysPerYearBetween(new Date(), birthday);
        if (dayNum<3 && dayNum>0){
            tip = "老子还有"+dayNum+"天就要生日了，你送啥！";
        }else if (dayNum == 0){
            tip = "约吗？";
        }

        // 不设置我的生日提醒
        tip = null;
        return tip;
    }

    private String getTogetherTip(Date together) {
        String tip = null;
        Date today = new Date();
        int dayNum = DateUtil.daysBetween(together, today);
        if (dayNum%10000 ==0){
            tip = "陪伴一万天，爱你一万年。";
        }else if (dayNum%1000 == 0){
            tip = "1000天文案";
        }else if (dayNum%100 == 0) {
            tip = "第几个一百天";
        }
        if (today.getMonth() == together.getMonth() && today.getDay()==together.getDay()){
            tip = "今天是我们在一起"+(today.getYear()-together.getYear())+"年纪念日哟";
        }
        return tip;
    }

    private String getWeddingTip(Date secret) {
        return "我们还莫有结婚";
    }

}