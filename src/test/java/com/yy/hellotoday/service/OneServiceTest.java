package com.yy.hellotoday.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * 描述:
 *
 * @author 2yLoo
 * @create 2019-05-11 17:48
 */
public class OneServiceTest {

    @Test
    public void saveOne() throws IOException {

        Document document = Jsoup.connect("http://wufazhuce.com/").get();
        Elements first = document.select("div[class=\"item active\"]").first().select("a");
        String img = first.select("img").attr("src");
        String content = first.get(1).text();

        System.out.println(img);
        System.out.println(content);
    }

}