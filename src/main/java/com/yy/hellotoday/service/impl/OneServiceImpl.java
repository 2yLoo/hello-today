package com.yy.hellotoday.service.impl;

import com.yy.hellotoday.model.One;
import com.yy.hellotoday.repository.OneRepository;
import com.yy.hellotoday.service.OneService;
import com.yy.hellotoday.utils.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 描述: 《一个》服务实现类
 *
 * @author 2yLoo
 * @create 2019-05-11 18:25
 */
@Service
public class OneServiceImpl implements OneService {

    private OneRepository oneRepository;

    @Autowired
    public OneServiceImpl(OneRepository oneRepository) {
        this.oneRepository = oneRepository;
    }

    @Override
    public One getAndSaveOne() throws IOException{
        Document document = Jsoup.connect("http://wufazhuce.com/").get();
        Elements first = document.select("div[class=\"item active\"]").first().select("a");
        String img = first.select("img").attr("src");
        String content = first.get(1).text();
        One one = new One(DateUtil.genDate(), img, content);
        return oneRepository.save(one);
    }
}