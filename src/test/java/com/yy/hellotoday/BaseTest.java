package com.yy.hellotoday;

import com.yy.hellotoday.utils.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * 描述:
 *
 * @author 2yLoo
 * @create 2019-05-09 19:23
 */
public class BaseTest {

    @Test
    public void testDate(){
        Date date = new Date();
        String a = DateUtil.genDate();
        System.out.println(a.substring(5));
    }

}